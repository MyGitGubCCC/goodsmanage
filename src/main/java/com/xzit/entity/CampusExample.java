package com.xzit.entity;

import java.util.ArrayList;
import java.util.List;

public class CampusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusExample() {
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

        public Criteria andCampusnameIsNull() {
            addCriterion("campusname is null");
            return (Criteria) this;
        }

        public Criteria andCampusnameIsNotNull() {
            addCriterion("campusname is not null");
            return (Criteria) this;
        }

        public Criteria andCampusnameEqualTo(String value) {
            addCriterion("campusname =", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameNotEqualTo(String value) {
            addCriterion("campusname <>", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameGreaterThan(String value) {
            addCriterion("campusname >", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameGreaterThanOrEqualTo(String value) {
            addCriterion("campusname >=", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameLessThan(String value) {
            addCriterion("campusname <", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameLessThanOrEqualTo(String value) {
            addCriterion("campusname <=", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameLike(String value) {
            addCriterion("campusname like", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameNotLike(String value) {
            addCriterion("campusname not like", value, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameIn(List<String> values) {
            addCriterion("campusname in", values, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameNotIn(List<String> values) {
            addCriterion("campusname not in", values, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameBetween(String value1, String value2) {
            addCriterion("campusname between", value1, value2, "campusname");
            return (Criteria) this;
        }

        public Criteria andCampusnameNotBetween(String value1, String value2) {
            addCriterion("campusname not between", value1, value2, "campusname");
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