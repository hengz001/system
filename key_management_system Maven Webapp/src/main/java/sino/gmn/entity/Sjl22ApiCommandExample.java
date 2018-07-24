package sino.gmn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sjl22ApiCommandExample implements Serializable{
	
	private static final long serialVersionUID = 7480191470781234962L;

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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSCommandIsNull() {
            addCriterion("s_command is null");
            return (Criteria) this;
        }

        public Criteria andSCommandIsNotNull() {
            addCriterion("s_command is not null");
            return (Criteria) this;
        }

        public Criteria andSCommandEqualTo(String value) {
            addCriterion("s_command =", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandNotEqualTo(String value) {
            addCriterion("s_command <>", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandGreaterThan(String value) {
            addCriterion("s_command >", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandGreaterThanOrEqualTo(String value) {
            addCriterion("s_command >=", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandLessThan(String value) {
            addCriterion("s_command <", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandLessThanOrEqualTo(String value) {
            addCriterion("s_command <=", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandLike(String value) {
            addCriterion("s_command like", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandNotLike(String value) {
            addCriterion("s_command not like", value, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandIn(List<String> values) {
            addCriterion("s_command in", values, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandNotIn(List<String> values) {
            addCriterion("s_command not in", values, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandBetween(String value1, String value2) {
            addCriterion("s_command between", value1, value2, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSCommandNotBetween(String value1, String value2) {
            addCriterion("s_command not between", value1, value2, "sCommand");
            return (Criteria) this;
        }

        public Criteria andSRequestIsNull() {
            addCriterion("s_request is null");
            return (Criteria) this;
        }

        public Criteria andSRequestIsNotNull() {
            addCriterion("s_request is not null");
            return (Criteria) this;
        }

        public Criteria andSRequestEqualTo(String value) {
            addCriterion("s_request =", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestNotEqualTo(String value) {
            addCriterion("s_request <>", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestGreaterThan(String value) {
            addCriterion("s_request >", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestGreaterThanOrEqualTo(String value) {
            addCriterion("s_request >=", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestLessThan(String value) {
            addCriterion("s_request <", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestLessThanOrEqualTo(String value) {
            addCriterion("s_request <=", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestLike(String value) {
            addCriterion("s_request like", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestNotLike(String value) {
            addCriterion("s_request not like", value, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestIn(List<String> values) {
            addCriterion("s_request in", values, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestNotIn(List<String> values) {
            addCriterion("s_request not in", values, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestBetween(String value1, String value2) {
            addCriterion("s_request between", value1, value2, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSRequestNotBetween(String value1, String value2) {
            addCriterion("s_request not between", value1, value2, "sRequest");
            return (Criteria) this;
        }

        public Criteria andSResponseIsNull() {
            addCriterion("s_response is null");
            return (Criteria) this;
        }

        public Criteria andSResponseIsNotNull() {
            addCriterion("s_response is not null");
            return (Criteria) this;
        }

        public Criteria andSResponseEqualTo(String value) {
            addCriterion("s_response =", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseNotEqualTo(String value) {
            addCriterion("s_response <>", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseGreaterThan(String value) {
            addCriterion("s_response >", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseGreaterThanOrEqualTo(String value) {
            addCriterion("s_response >=", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseLessThan(String value) {
            addCriterion("s_response <", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseLessThanOrEqualTo(String value) {
            addCriterion("s_response <=", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseLike(String value) {
            addCriterion("s_response like", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseNotLike(String value) {
            addCriterion("s_response not like", value, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseIn(List<String> values) {
            addCriterion("s_response in", values, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseNotIn(List<String> values) {
            addCriterion("s_response not in", values, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseBetween(String value1, String value2) {
            addCriterion("s_response between", value1, value2, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSResponseNotBetween(String value1, String value2) {
            addCriterion("s_response not between", value1, value2, "sResponse");
            return (Criteria) this;
        }

        public Criteria andSDescribeIsNull() {
            addCriterion("s_describe is null");
            return (Criteria) this;
        }

        public Criteria andSDescribeIsNotNull() {
            addCriterion("s_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSDescribeEqualTo(String value) {
            addCriterion("s_describe =", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeNotEqualTo(String value) {
            addCriterion("s_describe <>", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeGreaterThan(String value) {
            addCriterion("s_describe >", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("s_describe >=", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeLessThan(String value) {
            addCriterion("s_describe <", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeLessThanOrEqualTo(String value) {
            addCriterion("s_describe <=", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeLike(String value) {
            addCriterion("s_describe like", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeNotLike(String value) {
            addCriterion("s_describe not like", value, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeIn(List<String> values) {
            addCriterion("s_describe in", values, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeNotIn(List<String> values) {
            addCriterion("s_describe not in", values, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeBetween(String value1, String value2) {
            addCriterion("s_describe between", value1, value2, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSDescribeNotBetween(String value1, String value2) {
            addCriterion("s_describe not between", value1, value2, "sDescribe");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeIsNull() {
            addCriterion("s_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeIsNotNull() {
            addCriterion("s_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeEqualTo(Date value) {
            addCriterion("s_update_time =", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeNotEqualTo(Date value) {
            addCriterion("s_update_time <>", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeGreaterThan(Date value) {
            addCriterion("s_update_time >", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_update_time >=", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeLessThan(Date value) {
            addCriterion("s_update_time <", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("s_update_time <=", value, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeIn(List<Date> values) {
            addCriterion("s_update_time in", values, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeNotIn(List<Date> values) {
            addCriterion("s_update_time not in", values, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("s_update_time between", value1, value2, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("s_update_time not between", value1, value2, "sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserIsNull() {
            addCriterion("s_update_user is null");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserIsNotNull() {
            addCriterion("s_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserEqualTo(String value) {
            addCriterion("s_update_user =", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserNotEqualTo(String value) {
            addCriterion("s_update_user <>", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserGreaterThan(String value) {
            addCriterion("s_update_user >", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("s_update_user >=", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserLessThan(String value) {
            addCriterion("s_update_user <", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("s_update_user <=", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserLike(String value) {
            addCriterion("s_update_user like", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserNotLike(String value) {
            addCriterion("s_update_user not like", value, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserIn(List<String> values) {
            addCriterion("s_update_user in", values, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserNotIn(List<String> values) {
            addCriterion("s_update_user not in", values, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserBetween(String value1, String value2) {
            addCriterion("s_update_user between", value1, value2, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSUpdateUserNotBetween(String value1, String value2) {
            addCriterion("s_update_user not between", value1, value2, "sUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNull() {
            addCriterion("s_status is null");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNotNull() {
            addCriterion("s_status is not null");
            return (Criteria) this;
        }

        public Criteria andSStatusEqualTo(Integer value) {
            addCriterion("s_status =", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotEqualTo(Integer value) {
            addCriterion("s_status <>", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThan(Integer value) {
            addCriterion("s_status >", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_status >=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThan(Integer value) {
            addCriterion("s_status <", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThanOrEqualTo(Integer value) {
            addCriterion("s_status <=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusIn(List<Integer> values) {
            addCriterion("s_status in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotIn(List<Integer> values) {
            addCriterion("s_status not in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusBetween(Integer value1, Integer value2) {
            addCriterion("s_status between", value1, value2, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("s_status not between", value1, value2, "sStatus");
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