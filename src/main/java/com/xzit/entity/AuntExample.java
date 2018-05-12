package com.xzit.entity;

import java.util.ArrayList;
import java.util.List;

public class AuntExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuntExample() {
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

        public Criteria andAuntidIsNull() {
            addCriterion("auntid is null");
            return (Criteria) this;
        }

        public Criteria andAuntidIsNotNull() {
            addCriterion("auntid is not null");
            return (Criteria) this;
        }

        public Criteria andAuntidEqualTo(Integer value) {
            addCriterion("auntid =", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidNotEqualTo(Integer value) {
            addCriterion("auntid <>", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidGreaterThan(Integer value) {
            addCriterion("auntid >", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidGreaterThanOrEqualTo(Integer value) {
            addCriterion("auntid >=", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidLessThan(Integer value) {
            addCriterion("auntid <", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidLessThanOrEqualTo(Integer value) {
            addCriterion("auntid <=", value, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidIn(List<Integer> values) {
            addCriterion("auntid in", values, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidNotIn(List<Integer> values) {
            addCriterion("auntid not in", values, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidBetween(Integer value1, Integer value2) {
            addCriterion("auntid between", value1, value2, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntidNotBetween(Integer value1, Integer value2) {
            addCriterion("auntid not between", value1, value2, "auntid");
            return (Criteria) this;
        }

        public Criteria andAuntnameIsNull() {
            addCriterion("auntname is null");
            return (Criteria) this;
        }

        public Criteria andAuntnameIsNotNull() {
            addCriterion("auntname is not null");
            return (Criteria) this;
        }

        public Criteria andAuntnameEqualTo(String value) {
            addCriterion("auntname =", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameNotEqualTo(String value) {
            addCriterion("auntname <>", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameGreaterThan(String value) {
            addCriterion("auntname >", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameGreaterThanOrEqualTo(String value) {
            addCriterion("auntname >=", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameLessThan(String value) {
            addCriterion("auntname <", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameLessThanOrEqualTo(String value) {
            addCriterion("auntname <=", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameLike(String value) {
            addCriterion("auntname like", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameNotLike(String value) {
            addCriterion("auntname not like", value, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameIn(List<String> values) {
            addCriterion("auntname in", values, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameNotIn(List<String> values) {
            addCriterion("auntname not in", values, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameBetween(String value1, String value2) {
            addCriterion("auntname between", value1, value2, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnameNotBetween(String value1, String value2) {
            addCriterion("auntname not between", value1, value2, "auntname");
            return (Criteria) this;
        }

        public Criteria andAuntnoIsNull() {
            addCriterion("auntno is null");
            return (Criteria) this;
        }

        public Criteria andAuntnoIsNotNull() {
            addCriterion("auntno is not null");
            return (Criteria) this;
        }

        public Criteria andAuntnoEqualTo(String value) {
            addCriterion("auntno =", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoNotEqualTo(String value) {
            addCriterion("auntno <>", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoGreaterThan(String value) {
            addCriterion("auntno >", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoGreaterThanOrEqualTo(String value) {
            addCriterion("auntno >=", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoLessThan(String value) {
            addCriterion("auntno <", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoLessThanOrEqualTo(String value) {
            addCriterion("auntno <=", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoLike(String value) {
            addCriterion("auntno like", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoNotLike(String value) {
            addCriterion("auntno not like", value, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoIn(List<String> values) {
            addCriterion("auntno in", values, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoNotIn(List<String> values) {
            addCriterion("auntno not in", values, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoBetween(String value1, String value2) {
            addCriterion("auntno between", value1, value2, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntnoNotBetween(String value1, String value2) {
            addCriterion("auntno not between", value1, value2, "auntno");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordIsNull() {
            addCriterion("auntpassword is null");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordIsNotNull() {
            addCriterion("auntpassword is not null");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordEqualTo(String value) {
            addCriterion("auntpassword =", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordNotEqualTo(String value) {
            addCriterion("auntpassword <>", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordGreaterThan(String value) {
            addCriterion("auntpassword >", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("auntpassword >=", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordLessThan(String value) {
            addCriterion("auntpassword <", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordLessThanOrEqualTo(String value) {
            addCriterion("auntpassword <=", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordLike(String value) {
            addCriterion("auntpassword like", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordNotLike(String value) {
            addCriterion("auntpassword not like", value, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordIn(List<String> values) {
            addCriterion("auntpassword in", values, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordNotIn(List<String> values) {
            addCriterion("auntpassword not in", values, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordBetween(String value1, String value2) {
            addCriterion("auntpassword between", value1, value2, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntpasswordNotBetween(String value1, String value2) {
            addCriterion("auntpassword not between", value1, value2, "auntpassword");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoIsNull() {
            addCriterion("auntphoneNo is null");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoIsNotNull() {
            addCriterion("auntphoneNo is not null");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoEqualTo(String value) {
            addCriterion("auntphoneNo =", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoNotEqualTo(String value) {
            addCriterion("auntphoneNo <>", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoGreaterThan(String value) {
            addCriterion("auntphoneNo >", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoGreaterThanOrEqualTo(String value) {
            addCriterion("auntphoneNo >=", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoLessThan(String value) {
            addCriterion("auntphoneNo <", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoLessThanOrEqualTo(String value) {
            addCriterion("auntphoneNo <=", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoLike(String value) {
            addCriterion("auntphoneNo like", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoNotLike(String value) {
            addCriterion("auntphoneNo not like", value, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoIn(List<String> values) {
            addCriterion("auntphoneNo in", values, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoNotIn(List<String> values) {
            addCriterion("auntphoneNo not in", values, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoBetween(String value1, String value2) {
            addCriterion("auntphoneNo between", value1, value2, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andAuntphonenoNotBetween(String value1, String value2) {
            addCriterion("auntphoneNo not between", value1, value2, "auntphoneno");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNull() {
            addCriterion("buildingid is null");
            return (Criteria) this;
        }

        public Criteria andBuildingidIsNotNull() {
            addCriterion("buildingid is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingidEqualTo(Integer value) {
            addCriterion("buildingid =", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotEqualTo(Integer value) {
            addCriterion("buildingid <>", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThan(Integer value) {
            addCriterion("buildingid >", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("buildingid >=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThan(Integer value) {
            addCriterion("buildingid <", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidLessThanOrEqualTo(Integer value) {
            addCriterion("buildingid <=", value, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidIn(List<Integer> values) {
            addCriterion("buildingid in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotIn(List<Integer> values) {
            addCriterion("buildingid not in", values, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidBetween(Integer value1, Integer value2) {
            addCriterion("buildingid between", value1, value2, "buildingid");
            return (Criteria) this;
        }

        public Criteria andBuildingidNotBetween(Integer value1, Integer value2) {
            addCriterion("buildingid not between", value1, value2, "buildingid");
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