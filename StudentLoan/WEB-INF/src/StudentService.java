

import model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/studentservice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();


    @POST
    @Path("/createStudent")
    @Consumes("application/json")
    public Response createStudent(Student student) {
        studentDAO.saveStudent(student);
        return Response.status(Response.Status.CREATED).entity(student).build();
    }


    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") Long id) {
        Student student = studentDAO.findStudent(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(student).build();
    }


    @GET
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") Long id, Student student) {
        Student existingStudent = studentDAO.findStudent(id);
        if (existingStudent == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


        existingStudent.setName(student.getName());
        existingStudent.setStudentNumber(student.getStudentNumber());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setProgrammeCode(student.getProgrammeCode());

        studentDAO.updateStudent(existingStudent);
        return Response.ok(existingStudent).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Long id) {
        Student student = studentDAO.findStudent(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        studentDAO.deleteStudent(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
