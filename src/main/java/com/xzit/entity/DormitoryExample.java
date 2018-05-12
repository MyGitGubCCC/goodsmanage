package com.xzit.entity;

import java.util.ArrayList;
import java.util.List;

public class DormitoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DormitoryExample() {
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

        public Criteria andDormitoryidIsNull() {
            addCriterion("dormitoryid is null");
            return (Criteria) this;
        }

        public Criteria andDormitoryidIsNotNull() {
            addCriterion("dormitoryid is not null");
            return (Criteria) this;
        }

        public Criteria andDormitoryidEqualTo(Integer value) {
            addCriterion("dormitoryid =", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidNotEqualTo(Integer value) {
            addCriterion("dormitoryid <>", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidGreaterThan(Integer value) {
            addCriterion("dormitoryid >", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormitoryid >=", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidLessThan(Integer value) {
            addCriterion("dormitoryid <", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidLessThanOrEqualTo(Integer value) {
            addCriterion("dormitoryid <=", value, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidIn(List<Integer> values) {
            addCriterion("dormitoryid in", values, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidNotIn(List<Integer> values) {
            addCriterion("dormitoryid not in", values, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidBetween(Integer value1, Integer value2) {
            addCriterion("dormitoryid between", value1, value2, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("dormitoryid not between", value1, value2, "dormitoryid");
            return (Criteria) this;
        }

        public Criteria andDormitorynoIsNull() {
            addCriterion("dormitoryNo is null");
            return (Criteria) this;
        }

        public Criteria andDormitorynoIsNotNull() {
            addCriterion("dormitoryNo is not null");
            return (Criteria) this;
        }

        public Criteria andDormitorynoEqualTo(String value) {
            addCriterion("dormitoryNo =", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoNotEqualTo(String value) {
            addCriterion("dormitoryNo <>", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoGreaterThan(String value) {
            addCriterion("dormitoryNo >", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoGreaterThanOrEqualTo(String value) {
            addCriterion("dormitoryNo >=", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoLessThan(String value) {
            addCriterion("dormitoryNo <", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoLessThanOrEqualTo(String value) {
            addCriterion("dormitoryNo <=", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoLike(String value) {
            addCriterion("dormitoryNo like", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoNotLike(String value) {
            addCriterion("dormitoryNo not like", value, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoIn(List<String> values) {
            addCriterion("dormitoryNo in", values, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoNotIn(List<String> values) {
            addCriterion("dormitoryNo not in", values, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoBetween(String value1, String value2) {
            addCriterion("dormitoryNo between", value1, value2, "dormitoryno");
            return (Criteria) this;
        }

        public Criteria andDormitorynoNotBetween(String value1, String value2) {
            addCriterion("dormitoryNo not between", value1, value2, "dormitoryno");
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