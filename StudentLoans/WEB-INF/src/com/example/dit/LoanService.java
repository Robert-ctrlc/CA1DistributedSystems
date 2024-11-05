package com.example.dit;

import com.example.dit.dto.LoanDTO;
import com.example.dit.model.Loan;
import com.example.dit.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/loanservice")
public class LoanService {

    private StudentDAO studentDAO = new StudentDAO();

    @POST
    @Path("/createLoan/{studentId}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createLoan(@PathParam("studentId") Long studentId, Loan loan) {
        Student student = studentDAO.findStudent(studentId);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        loan.setStudent(student);
        studentDAO.saveLoan(loan);
        
        LoanDTO loanDTO = new LoanDTO(loan.getId(), loan.getDescription(), loan.getLoanAmount());
        return Response.status(Response.Status.CREATED).entity(loanDTO).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getLoan(@PathParam("id") Long id) {
        Loan loan = studentDAO.findLoan(id);
        if (loan == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    
        
        loan.getDeposits().size();
    
        LoanDTO loanDTO = new LoanDTO(loan.getId(), loan.getDescription(), loan.getLoanAmount());
        return Response.ok(loanDTO).build();
    }
    
}
