package com.bank.controller;

import java.io.IOException;

import com.bank.dao.BeneficiaryDAO;
import com.bank.model.Beneficiary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddBeneficiaryServlet")
public class AddBeneficiaryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }


        com.bank.model.User user =
                (com.bank.model.User) session.getAttribute("user");


        String name = request.getParameter("beneficiaryName");
        String accountNumber = request.getParameter("accountNumber");
        String bankName = request.getParameter("bankName");
        String ifscCode = request.getParameter("ifscCode");


        Beneficiary beneficiary = new Beneficiary();

        beneficiary.setUserId(user.getId());
        beneficiary.setBeneficiaryName(name);
        beneficiary.setAccountNumber(accountNumber);
        beneficiary.setBankName(bankName);
        beneficiary.setIfscCode(ifscCode);


        BeneficiaryDAO dao = new BeneficiaryDAO();

        boolean status = dao.addBeneficiary(beneficiary);


        if(status) {
            response.sendRedirect("viewBeneficiary.jsp");
        }
        else {
            response.sendRedirect("addBeneficiary.jsp?error=failed");
        }

    }
}