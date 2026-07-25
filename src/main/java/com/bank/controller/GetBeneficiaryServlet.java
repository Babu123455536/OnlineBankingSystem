package com.bank.controller;

import java.io.IOException;
import java.util.List;

import com.bank.dao.BeneficiaryDAO;
import com.bank.model.Beneficiary;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/GetBeneficiaryServlet")
public class GetBeneficiaryServlet extends HttpServlet {

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


        BeneficiaryDAO dao = new BeneficiaryDAO();


        List<Beneficiary> list =
                dao.getBeneficiaries(user.getId());


        request.setAttribute("beneficiaries", list);


        request.getRequestDispatcher("transfer.jsp")
               .forward(request, response);

    }
}