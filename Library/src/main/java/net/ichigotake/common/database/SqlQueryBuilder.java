package net.ichigotake.common.database;

import android.text.TextUtils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SqlQueryBuilder {

    public static Where where() {
        return new Where();
    }

    /**
     * TODO: 設計もせずに動作優先で深夜に勢いで作ったもの。ちゃんとした入れ子が出来るように再設計すべき
     */
    public static class Where {

        private final List<String> conditions;
        private final List<String> values;

        private Where() {
            conditions = new CopyOnWriteArrayList<String>();
            values = new CopyOnWriteArrayList<String>();
        }

        public Where and(String key, Object value) {
            conditions.add(String.format("%s = ?", key));
            values.add(value.toString());
            return this;
        }

        public Where like(String key, Object value) {
            conditions.add(String.format("%s LIKE ?", key));
            values.add(value.toString());
            return this;
        }

        public String getQuery() {
            String query;
            if (conditions.isEmpty()) {
                query = "";
            } else {
                query = "(" + TextUtils.join(") AND (", conditions) + ")";
            }
            return query;
        }

        public boolean hasConditions() {
            return !conditions.isEmpty();
        }

        public Object[] getArguments() {
            return values.toArray();
        }

        @Override
        public String toString() {
            return getQuery();
        }
    }
}
