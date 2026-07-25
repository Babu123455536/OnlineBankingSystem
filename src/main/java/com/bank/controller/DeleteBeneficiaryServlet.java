package com.bank.controller;

import java.io.IOException;

import com.bank.dao.BeneficiaryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeleteBeneficiaryServlet")
public class DeleteBeneficiaryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        int beneficiaryId = Integer.parseInt(
                request.getParameter("beneficiaryId")
        );


        BeneficiaryDAO dao = new BeneficiaryDAO();


        dao.deleteBeneficiary(beneficiaryId);


        response.sendRedirect("ViewBeneficiaryServlet");

    }
}