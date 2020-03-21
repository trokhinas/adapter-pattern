package com.patterns.adapter.data;

import com.patterns.adapter.abstr.Contact;
import com.patterns.adapter.abstr.Customer;
import com.patterns.adapter.abstr.IncomeData;
import com.patterns.adapter.utils.CountryUtils;
import com.patterns.adapter.utils.PhoneNumberUtils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.StringJoiner;

public class IncomeDataAdapter implements Customer, Contact {
    private final IncomeData incomeData;

    public IncomeDataAdapter(IncomeData incomeData) {
        this.incomeData = incomeData;
    }

    @Override
    public String getName() {
        String firstName = incomeData.getContactFirstName();
        String lastName = incomeData.getContactLastName();

        StringJoiner joiner = new StringJoiner(", ");
        return joiner.add(lastName).add(firstName).toString();
    }

    @Override
    public String getPhoneNumber() {
        StringBuilder builder = new StringBuilder();
        String formattedNumber = PhoneNumberUtils.formatNumber(String.valueOf(incomeData.getPhoneNumber()));

        return MessageFormat.format("+{0}{1}", incomeData.getCountryPhoneCode(), formattedNumber);
    }

    @Override
    public String getCompanyName() {
        return String.valueOf(incomeData.getCompany());
    }

    @Override
    public String getCountryName() {
        String code = String.valueOf(incomeData.getCountryCode());
        return CountryUtils.getCountryByCode(code);
    }
}
