package com.example.dit;


import com.example.dit.model.Deposit;
import com.example.dit.model.Loan;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/depositservice")
public class DepositService {

    private StudentDAO studentDAO = new StudentDAO();

    @POST
    @Path("/addDeposit/{loanId}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addDeposit(@PathParam("loanId") Long loanId, Deposit deposit) {
        Loan loan = studentDAO.findLoan(loanId);
        if (loan == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        loan.addDeposit(deposit);
        
       
        double newLoanAmount = loan.getLoanAmount() - deposit.getAmount();
        loan.setLoanAmount(newLoanAmount);
        
      
        studentDAO.saveDeposit(deposit);
        studentDAO.updateLoan(loan); 
        
        return Response.status(Response.Status.CREATED).entity(deposit).build();
}
}

