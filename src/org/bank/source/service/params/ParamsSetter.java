package org.bank.source.service.params;

import org.bank.source.model.QueryBuilderParams;

public interface ParamsSetter {
    StringBuilder setParams(QueryBuilderParams queryBuilderParams);
}
