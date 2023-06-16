package se.andreas.calc;

import jakarta.enterprise.context.RequestScoped;
import se.andreas.calc.model.CalcRes;
import se.andreas.calc.model.Message;

import java.util.List;

@RequestScoped
public class CalcService {

    public CalcRes calc(String query) {
        return simpleCalc(query);
    }

    public CalcRes simpleCalc(String query) {
        try {
            List<String> nominators = List.of(query.split("\\+"));
            if (nominators.size() == 2) {
                return new CalcRes(query, Integer.parseInt(nominators.get(0)) + Integer.parseInt(nominators.get(1)));
            }

            nominators = List.of(query.split("-"));
            if (nominators.size() == 2) {
                return new CalcRes(query, Integer.parseInt(nominators.get(0)) - Integer.parseInt(nominators.get(1)));
            }

            nominators = List.of(query.split("\\*"));
            if (nominators.size() == 2) {
                return new CalcRes(query, Integer.parseInt(nominators.get(0)) * Integer.parseInt(nominators.get(1)));
            }

            nominators = List.of(query.split("/"));
            if (nominators.size() == 2) {
                if(Integer.parseInt(nominators.get(1)) == 0) {
                    return new CalcRes(query, Message.DIVIDE_BY_ZERO);
                } else {
                    return new CalcRes(query, Integer.parseInt(nominators.get(0)) / Integer.parseInt(nominators.get(1)));
                }
            }
        } catch (NumberFormatException e) {
            return new CalcRes(query, Message.COULD_NOT_UNDERSTAND_QUERY);
        }

        return new CalcRes(query, Message.NO_OPERATOR_FOUND);
    }
}
