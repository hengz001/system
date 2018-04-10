package sino.gmn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sjl22ApiCommandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Sjl22ApiCommandExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andCommandIsNull() {
            addCriterion("command is null");
            return (Criteria) this;
        }

        public Criteria andCommandIsNotNull() {
            addCriterion("command is not null");
            return (Criteria) this;
        }

        public Criteria andCommandEqualTo(String value) {
            addCriterion("command =", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotEqualTo(String value) {
            addCriterion("command <>", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThan(String value) {
            addCriterion("command >", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThanOrEqualTo(String value) {
            addCriterion("command >=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThan(String value) {
            addCriterion("command <", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThanOrEqualTo(String value) {
            addCriterion("command <=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLike(String value) {
            addCriterion("command like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotLike(String value) {
            addCriterion("command not like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandIn(List<String> values) {
            addCriterion("command in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotIn(List<String> values) {
            addCriterion("command not in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandBetween(String value1, String value2) {
            addCriterion("command between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotBetween(String value1, String value2) {
            addCriterion("command not between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andRequestIsNull() {
            addCriterion("request is null");
            return (Criteria) this;
        }

        public Criteria andRequestIsNotNull() {
            addCriterion("request is not null");
            return (Criteria) this;
        }

        public Criteria andRequestEqualTo(String value) {
            addCriterion("request =", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotEqualTo(String value) {
            addCriterion("request <>", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThan(String value) {
            addCriterion("request >", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThanOrEqualTo(String value) {
            addCriterion("request >=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThan(String value) {
            addCriterion("request <", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThanOrEqualTo(String value) {
            addCriterion("request <=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLike(String value) {
            addCriterion("request like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotLike(String value) {
            addCriterion("request not like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestIn(List<String> values) {
            addCriterion("request in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotIn(List<String> values) {
            addCriterion("request not in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestBetween(String value1, String value2) {
            addCriterion("request between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotBetween(String value1, String value2) {
            addCriterion("request not between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andResponseIsNull() {
            addCriterion("response is null");
            return (Criteria) this;
        }

        public Criteria andResponseIsNotNull() {
            addCriterion("response is not null");
            return (Criteria) this;
        }

        public Criteria andResponseEqualTo(String value) {
            addCriterion("response =", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotEqualTo(String value) {
            addCriterion("response <>", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseGreaterThan(String value) {
            addCriterion("response >", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseGreaterThanOrEqualTo(String value) {
            addCriterion("response >=", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLessThan(String value) {
            addCriterion("response <", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLessThanOrEqualTo(String value) {
            addCriterion("response <=", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLike(String value) {
            addCriterion("response like", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotLike(String value) {
            addCriterion("response not like", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseIn(List<String> values) {
            addCriterion("response in", values, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotIn(List<String> values) {
            addCriterion("response not in", values, "response");
            return (Criteria) this;
        }

        public Criteria andResponseBetween(String value1, String value2) {
            addCriterion("response between", value1, value2, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotBetween(String value1, String value2) {
            addCriterion("response not between", value1, value2, "response");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}