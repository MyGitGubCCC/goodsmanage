package com.xzit.entity;

import java.util.ArrayList;
import java.util.List;

public class AcademyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcademyExample() {
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

        public Criteria andAcademyidIsNull() {
            addCriterion("academyid is null");
            return (Criteria) this;
        }

        public Criteria andAcademyidIsNotNull() {
            addCriterion("academyid is not null");
            return (Criteria) this;
        }

        public Criteria andAcademyidEqualTo(Integer value) {
            addCriterion("academyid =", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidNotEqualTo(Integer value) {
            addCriterion("academyid <>", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidGreaterThan(Integer value) {
            addCriterion("academyid >", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("academyid >=", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidLessThan(Integer value) {
            addCriterion("academyid <", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidLessThanOrEqualTo(Integer value) {
            addCriterion("academyid <=", value, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidIn(List<Integer> values) {
            addCriterion("academyid in", values, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidNotIn(List<Integer> values) {
            addCriterion("academyid not in", values, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidBetween(Integer value1, Integer value2) {
            addCriterion("academyid between", value1, value2, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademyidNotBetween(Integer value1, Integer value2) {
            addCriterion("academyid not between", value1, value2, "academyid");
            return (Criteria) this;
        }

        public Criteria andAcademynameIsNull() {
            addCriterion("academyname is null");
            return (Criteria) this;
        }

        public Criteria andAcademynameIsNotNull() {
            addCriterion("academyname is not null");
            return (Criteria) this;
        }

        public Criteria andAcademynameEqualTo(String value) {
            addCriterion("academyname =", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotEqualTo(String value) {
            addCriterion("academyname <>", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameGreaterThan(String value) {
            addCriterion("academyname >", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameGreaterThanOrEqualTo(String value) {
            addCriterion("academyname >=", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLessThan(String value) {
            addCriterion("academyname <", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLessThanOrEqualTo(String value) {
            addCriterion("academyname <=", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameLike(String value) {
            addCriterion("academyname like", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotLike(String value) {
            addCriterion("academyname not like", value, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameIn(List<String> values) {
            addCriterion("academyname in", values, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotIn(List<String> values) {
            addCriterion("academyname not in", values, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameBetween(String value1, String value2) {
            addCriterion("academyname between", value1, value2, "academyname");
            return (Criteria) this;
        }

        public Criteria andAcademynameNotBetween(String value1, String value2) {
            addCriterion("academyname not between", value1, value2, "academyname");
            return (Criteria) this;
        }

        public Criteria andCampusidIsNull() {
            addCriterion("campusid is null");
            return (Criteria) this;
        }

        public Criteria andCampusidIsNotNull() {
            addCriterion("campusid is not null");
            return (Criteria) this;
        }

        public Criteria andCampusidEqualTo(Integer value) {
            addCriterion("campusid =", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidNotEqualTo(Integer value) {
            addCriterion("campusid <>", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidGreaterThan(Integer value) {
            addCriterion("campusid >", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("campusid >=", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidLessThan(Integer value) {
            addCriterion("campusid <", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidLessThanOrEqualTo(Integer value) {
            addCriterion("campusid <=", value, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidIn(List<Integer> values) {
            addCriterion("campusid in", values, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidNotIn(List<Integer> values) {
            addCriterion("campusid not in", values, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidBetween(Integer value1, Integer value2) {
            addCriterion("campusid between", value1, value2, "campusid");
            return (Criteria) this;
        }

        public Criteria andCampusidNotBetween(Integer value1, Integer value2) {
            addCriterion("campusid not between", value1, value2, "campusid");
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