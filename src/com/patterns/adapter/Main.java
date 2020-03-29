package com.patterns.adapter;

import com.patterns.adapter.abstr.IncomeData;
import com.patterns.adapter.data.IncomeDataAdapter;

public class Main {


    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public Integer getCountryPhoneCode() {
                return 38;
            }

            @Override
            public Integer getPhoneNumber() {
                return 501234567;
            }
        };
        IncomeDataAdapter dataAdapter = new IncomeDataAdapter(incomeData);

        System.out.println(dataAdapter.getCompanyName());
        System.out.println(dataAdapter.getCountryName());
        System.out.println(dataAdapter.getName());
        System.out.println(dataAdapter.getPhoneNumber());
    }
}
