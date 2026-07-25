package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;
import com.bank.model.User;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DownloadStatementServlet")
public class DownloadStatementServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);


        if(session == null || session.getAttribute("user") == null) {

            response.sendRedirect("login.jsp");
            return;
        }


        User user = (User) session.getAttribute("user");

        System.out.println("LOGIN USER ID = " + user.getId());
        System.out.println("LOGIN USER NAME = " + user.getName());
       

        response.setContentType("application/pdf");


        response.setHeader(
                "Content-Disposition",
                "attachment; filename=BankStatement.pdf"
        );


        try {


            Document document = new Document();


            PdfWriter.getInstance(
                    document,
                    response.getOutputStream()
            );


            document.open();


            document.add(
                    new Paragraph("ONLINE BANKING SYSTEM")
            );


            document.add(
                    new Paragraph("------------------------------")
            );


            document.add(
                    new Paragraph(
                    "Customer Name : "
                    + user.getName())
            );


            document.add(
                    new Paragraph(
                    "Email : "
                    + user.getEmail())
            );


            document.add(
                    new Paragraph("------------------------------")
            );


            document.add(
                    new Paragraph("Transaction History")
            );


            document.add(
                    new Paragraph("------------------------------")
            );



            TransactionDAO dao = new TransactionDAO();


            ArrayList<Transaction> list =
                    dao.getTransactionsByUser(user.getId());


            System.out.println(
                    "TRANSACTION COUNT = "
                    + list.size()
            );



            if(list.isEmpty()) {


                document.add(
                    new Paragraph(
                    "No Transactions Found"
                    )
                );


            } else {


                for(Transaction t : list) {


                    document.add(
                        new Paragraph(

                        "Transaction ID : "
                        + t.getTransactionId()

                        + " | Type : "
                        + t.getTransactionType()

                        + " | Amount : ₹"
                        + t.getAmount()

                        + " | Date : "
                        + t.getTransactionDate()

                        )
                    );

                }

            }


            document.close();


        } catch(Exception e) {

            e.printStackTrace();

        }

    }

}