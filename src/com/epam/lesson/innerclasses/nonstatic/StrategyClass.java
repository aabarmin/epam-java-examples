package com.epam.lesson.innerclasses.nonstatic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrategyClass {
    public <PARAM, DATA, FORMAT> FORMAT runStrategy(
            ParameterGetter<? extends PARAM> getter,
            ReportProducer<? super PARAM, ? extends DATA> producer,
            ReportWriter<? super DATA, ? extends FORMAT> writer
    ) {
        final PARAM params = getter.getParams();
        final DATA data = producer.buildReport(params);
        final FORMAT formattedData = writer.write(data);
        return formattedData;
    }

    public static void main(String[] args) {
        final StrategyClass strategyClass = new StrategyClass();

        String sourceValue = "2020";
        class DefaultParameterGetter implements ParameterGetter<String> {
            @Override
            public String getParams() {
                return sourceValue;
            }
        }

        final DefaultParameterGetter getter = new DefaultParameterGetter();
        final ReportProducer producer = strategyClass.new ReportProducerImpl();

        final String value = strategyClass.runStrategy(getter, producer, new ReportWriter<Date, String>() {
            @Override
            public String write(Date date) {
                return date.toString();
            }
        });

        System.out.println(value);
    }

    class Inner {
        public static final int val = 10;
    }

    class ReportProducerImpl implements ReportProducer<String, Date> {
        public static final String ss = "";

        @Override
        public Date buildReport(String params) {
            try {
                return new SimpleDateFormat("YYYY").parse(params);
            } catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    interface ParameterGetter<PARAM> {
        PARAM getParams();
    }

    interface ReportProducer<PARAM, DATA> {
        DATA buildReport(PARAM params);
    }

    interface ReportWriter<DATA, FORMAT> {
        FORMAT write(DATA data);
    }
}
