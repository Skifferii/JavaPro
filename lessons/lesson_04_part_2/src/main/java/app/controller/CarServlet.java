package app.controller;

import app.model.Car;
import app.repository.CarRepository;
import app.repository.CarRepositoryDB;
import app.repository.CarRepositoryHibernate;
import app.repository.CarRepositoryMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CarServlet extends HttpServlet {
    private CarRepository repository = new CarRepositoryHibernate()

            ;
    private ObjectMapper mapper = new ObjectMapper();

    //GET http://10.2.3.34:8080/cars
    //get http://localhost:8080/cars?id=1 take 1 auto from ID

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Устанавливаем тип контента JSON
        response.setContentType("application/json");

        Map<String, String[]> params = request.getParameterMap();


        if (params.isEmpty()) {
            // Пришел запрос /cars
            List<Car> cars = repository.getAll();

            // Преобразуем список машин в JSON
            String json = mapper.writeValueAsString(cars);

            response.getWriter().write(json);
        } else {
            // В запросе есть какие-то параметры
            String idFromMap = params.get("id")[0];
            Long id = Long.parseLong(idFromMap);
            Car car =repository.findById(id);
            if (car == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Car not found");
            }else {
                String json = mapper.writeValueAsString(car);
                response.getWriter().write(json);
            }
        }


//        List<Car> cars = repository.getAll();
//
//        String json =mapper.writeValueAsString(cars);
//
//        response.setContentType("application/json");
//        response.getWriter().write(json);



//        cars.forEach(car -> {
//            try {
//                response.getWriter().write(car.toString());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Данные автомобиля, отправленные клиентом в виде JSON
        // считываются из тела запроса и преобразуются в Java-объект типа Car.
                Car car =mapper.readValue(request.getReader(), Car.class);

                Car result = repository.save(car);

                // Zuruck to JSON
        String json = mapper.writeValueAsString(result);

        response.getWriter().write(json);

    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
    }
}
