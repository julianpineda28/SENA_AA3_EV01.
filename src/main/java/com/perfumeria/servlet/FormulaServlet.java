
package com.perfumeria.servlet;

import com.perfumeria.modelo.Formula;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Registra la dirección que utilizará el formulario para enviar los datos.
@WebServlet("/registrar-formula")
public class FormulaServlet extends HttpServlet {

    // Procesa los datos enviados por el formulario mediante el método POST.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        // Recibe los datos enviados desde los campos del formulario HTML.
        String nombre = request.getParameter("nombre");
        String cantidadTexto = request.getParameter("cantidad");
        String fechaTexto = request.getParameter("fechaElaboracion");
        String responsable = request.getParameter("responsable");

        // Convierte la cantidad recibida como texto a un número decimal.
        
double cantidad;
LocalDate fechaElaboracion;

try {
    // Convierte el texto recibido en una cantidad decimal.
    cantidad = Double.parseDouble(cantidadTexto);

    // Convierte el texto recibido en una fecha.
    fechaElaboracion = LocalDate.parse(fechaTexto);

    // Comprueba que la cantidad sea un número positivo y finito.
    if (!Double.isFinite(cantidad) || cantidad <= 0) {
        response.sendError(
            HttpServletResponse.SC_BAD_REQUEST,
            "La cantidad debe ser un número mayor que cero."
        );
        return;
    }

} catch (NumberFormatException | java.time.format.DateTimeParseException e) {
    // Informa que la cantidad o la fecha no tienen un formato válido.
    response.sendError(
        HttpServletResponse.SC_BAD_REQUEST,
        "Verifique que la cantidad y la fecha sean válidas."
    );
    return;
}
        
        // Crea el objeto que representa la formulación recibida.
        // El identificador 1 es provisional; todavía no usamos una base de datos.
        Formula formula = new Formula(
                1, nombre, cantidad, fechaElaboracion, responsable
        );

        // Indica que la respuesta que recibirá el navegador será HTML y usará UTF-8.
        response.setContentType("text/html;charset=UTF-8");

        // Construye la página HTML que muestra el resultado del registro.
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang='es'>");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset='UTF-8'>");
        response.getWriter().println("<title>Resultado del registro</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");

        // Presenta los datos de la formulación recibida.
        response.getWriter().println("<h1>Formulación recibida correctamente</h1>");
        response.getWriter().println("<p>Nombre del perfume: " + formula.getNombre() + "</p>");
        response.getWriter().println("<p>Cantidad: " + formula.getCantidad() + "</p>");
        response.getWriter().println("<p>Fecha de elaboración: " + formula.getFechaElaboracion() + "</p>");
        response.getWriter().println("<p>Responsable: " + formula.getResponsable() + "</p>");

        // Cierra el cuerpo y el documento HTML.
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}

