package net.ichigotake.common.database;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: プレースホルダと引数の数に差があったら例外を投げる
 */
public final class ConditionQueryBuilder {

    private final String LOGICAL_OPERATOR_AND = "AND";
    private final List<String> conditions;
    private final List<Object> values;
    private final List<String> logicalOperators;

    public ConditionQueryBuilder() {
        conditions = new CopyOnWriteArrayList<String>();
        values = new CopyOnWriteArrayList<Object>();
        logicalOperators = new CopyOnWriteArrayList<String>();
    }

    public ConditionQueryBuilder and(String condition, Object... arguments) {
        if (conditions.size() > 0) {
            logicalOperators.add(LOGICAL_OPERATOR_AND);
        }
        conditions.add(condition);
        values.addAll(Arrays.asList(arguments));
        return this;
    }

    public String getQuery() {
        if (conditions.isEmpty()) {
            return "";
        }

        String query = "";
        for (int i=0,size=conditions.size(); i<size; i++) {
            if (0 < i) {
                query += " " + logicalOperators.get(i-1) + " ";
            }
            query += "(" + conditions.get(i) + ")";
        }
        return query;
    }

    public Object[] getArguments() {
        return values.toArray(new Object[values.size()]);
    }

    @Override
    public String toString() {
        return getQuery();
    }

}
