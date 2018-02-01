package com.softwire.training.shipit.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class OrderSegment implements RenderableAsXML
{
    private Company company;
    private List<SummaryOrderLine> summaryOrderLines;

    public OrderSegment(Company company, List<SummaryOrderLine> summaryOrderLines)
    {
        this.company = company;
        this.summaryOrderLines = summaryOrderLines;
    }

    public Company getCompany()
    {
        return company;
    }

    public List<SummaryOrderLine> getSummaryOrderLines()
    {
        return summaryOrderLines;
    }

    public String renderXML()
    {
        StringBuilder renderedOrderLines = new StringBuilder();
        for (SummaryOrderLine summaryOrderLine : summaryOrderLines)
        {
            renderedOrderLines.append(summaryOrderLine.renderXML());
        }
        return "<segment>" +
                company.renderXML() +
                "<orderLines>" + renderedOrderLines.toString() + "</orderLines>" +
                "</segment>";
    }

    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        OrderSegment that = (OrderSegment) o;

        return new EqualsBuilder()
                .append(company, that.company)
                .append(summaryOrderLines, that.summaryOrderLines)
                .isEquals();
    }

    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(company)
                .append(summaryOrderLines)
                .toHashCode();
    }

    public String toString()
    {
        return new ToStringBuilder(this)
                .append("company", company)
                .append("orderLines", summaryOrderLines)
                .toString();
    }
}
