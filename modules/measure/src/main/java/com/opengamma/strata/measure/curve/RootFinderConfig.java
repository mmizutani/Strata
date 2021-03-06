/*
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.measure.curve;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.collect.ArgChecker;

/**
 * Configuration for the root finder used when calibrating curves.
 */
@BeanDefinition
public final class RootFinderConfig implements ImmutableBean, Serializable {

  /** The default absolute tolerance for the root finder. */
  public static final double DEFAULT_ABSOLUTE_TOLERANCE = 1e-9;

  /** The default relative tolerance for the root finder. */
  public static final double DEFAULT_RELATIVE_TOLERANCE = 1e-9;

  /** The default maximum number of steps for the root finder. */
  public static final int DEFAULT_MAXIMUM_STEPS = 1000;

  /** The standard configuration. */
  private static final RootFinderConfig STANDARD =
      new RootFinderConfig(DEFAULT_ABSOLUTE_TOLERANCE, DEFAULT_RELATIVE_TOLERANCE, DEFAULT_MAXIMUM_STEPS);

  /** The absolute tolerance for the root finder. */
  @PropertyDefinition(validate = "ArgChecker.notNegativeOrZero")
  private final double absoluteTolerance;

  /** The relative tolerance for the root finder. */
  @PropertyDefinition(validate = "ArgChecker.notNegativeOrZero")
  private final double relativeTolerance;

  /** The maximum number of steps for the root finder. */
  @PropertyDefinition(validate = "ArgChecker.notNegativeOrZero")
  private final int maximumSteps;

  //-------------------------------------------------------------------------
  /**
   * Returns standard root finder configuration, using the {@code DEFAULT} constants from this class.
   *
   * @return the standard root finder configuration, using the {@code DEFAULT} constants from this class
   */
  public static RootFinderConfig standard() {
    return STANDARD;
  }

  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.absoluteTolerance(DEFAULT_ABSOLUTE_TOLERANCE);
    builder.relativeTolerance(DEFAULT_RELATIVE_TOLERANCE);
    builder.maximumSteps(DEFAULT_MAXIMUM_STEPS);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code RootFinderConfig}.
   * @return the meta-bean, not null
   */
  public static RootFinderConfig.Meta meta() {
    return RootFinderConfig.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(RootFinderConfig.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static RootFinderConfig.Builder builder() {
    return new RootFinderConfig.Builder();
  }

  private RootFinderConfig(
      double absoluteTolerance,
      double relativeTolerance,
      int maximumSteps) {
    ArgChecker.notNegativeOrZero(absoluteTolerance, "absoluteTolerance");
    ArgChecker.notNegativeOrZero(relativeTolerance, "relativeTolerance");
    ArgChecker.notNegativeOrZero(maximumSteps, "maximumSteps");
    this.absoluteTolerance = absoluteTolerance;
    this.relativeTolerance = relativeTolerance;
    this.maximumSteps = maximumSteps;
  }

  @Override
  public RootFinderConfig.Meta metaBean() {
    return RootFinderConfig.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the absolute tolerance for the root finder.
   * @return the value of the property
   */
  public double getAbsoluteTolerance() {
    return absoluteTolerance;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the relative tolerance for the root finder.
   * @return the value of the property
   */
  public double getRelativeTolerance() {
    return relativeTolerance;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the maximum number of steps for the root finder.
   * @return the value of the property
   */
  public int getMaximumSteps() {
    return maximumSteps;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      RootFinderConfig other = (RootFinderConfig) obj;
      return JodaBeanUtils.equal(absoluteTolerance, other.absoluteTolerance) &&
          JodaBeanUtils.equal(relativeTolerance, other.relativeTolerance) &&
          (maximumSteps == other.maximumSteps);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(absoluteTolerance);
    hash = hash * 31 + JodaBeanUtils.hashCode(relativeTolerance);
    hash = hash * 31 + JodaBeanUtils.hashCode(maximumSteps);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("RootFinderConfig{");
    buf.append("absoluteTolerance").append('=').append(absoluteTolerance).append(',').append(' ');
    buf.append("relativeTolerance").append('=').append(relativeTolerance).append(',').append(' ');
    buf.append("maximumSteps").append('=').append(JodaBeanUtils.toString(maximumSteps));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code RootFinderConfig}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code absoluteTolerance} property.
     */
    private final MetaProperty<Double> absoluteTolerance = DirectMetaProperty.ofImmutable(
        this, "absoluteTolerance", RootFinderConfig.class, Double.TYPE);
    /**
     * The meta-property for the {@code relativeTolerance} property.
     */
    private final MetaProperty<Double> relativeTolerance = DirectMetaProperty.ofImmutable(
        this, "relativeTolerance", RootFinderConfig.class, Double.TYPE);
    /**
     * The meta-property for the {@code maximumSteps} property.
     */
    private final MetaProperty<Integer> maximumSteps = DirectMetaProperty.ofImmutable(
        this, "maximumSteps", RootFinderConfig.class, Integer.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "absoluteTolerance",
        "relativeTolerance",
        "maximumSteps");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -402212778:  // absoluteTolerance
          return absoluteTolerance;
        case 1517353633:  // relativeTolerance
          return relativeTolerance;
        case 715849959:  // maximumSteps
          return maximumSteps;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public RootFinderConfig.Builder builder() {
      return new RootFinderConfig.Builder();
    }

    @Override
    public Class<? extends RootFinderConfig> beanType() {
      return RootFinderConfig.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code absoluteTolerance} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> absoluteTolerance() {
      return absoluteTolerance;
    }

    /**
     * The meta-property for the {@code relativeTolerance} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> relativeTolerance() {
      return relativeTolerance;
    }

    /**
     * The meta-property for the {@code maximumSteps} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Integer> maximumSteps() {
      return maximumSteps;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -402212778:  // absoluteTolerance
          return ((RootFinderConfig) bean).getAbsoluteTolerance();
        case 1517353633:  // relativeTolerance
          return ((RootFinderConfig) bean).getRelativeTolerance();
        case 715849959:  // maximumSteps
          return ((RootFinderConfig) bean).getMaximumSteps();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code RootFinderConfig}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<RootFinderConfig> {

    private double absoluteTolerance;
    private double relativeTolerance;
    private int maximumSteps;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(RootFinderConfig beanToCopy) {
      this.absoluteTolerance = beanToCopy.getAbsoluteTolerance();
      this.relativeTolerance = beanToCopy.getRelativeTolerance();
      this.maximumSteps = beanToCopy.getMaximumSteps();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -402212778:  // absoluteTolerance
          return absoluteTolerance;
        case 1517353633:  // relativeTolerance
          return relativeTolerance;
        case 715849959:  // maximumSteps
          return maximumSteps;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -402212778:  // absoluteTolerance
          this.absoluteTolerance = (Double) newValue;
          break;
        case 1517353633:  // relativeTolerance
          this.relativeTolerance = (Double) newValue;
          break;
        case 715849959:  // maximumSteps
          this.maximumSteps = (Integer) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    /**
     * @deprecated Use Joda-Convert in application code
     */
    @Override
    @Deprecated
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    /**
     * @deprecated Use Joda-Convert in application code
     */
    @Override
    @Deprecated
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    /**
     * @deprecated Loop in application code
     */
    @Override
    @Deprecated
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public RootFinderConfig build() {
      return new RootFinderConfig(
          absoluteTolerance,
          relativeTolerance,
          maximumSteps);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the absolute tolerance for the root finder.
     * @param absoluteTolerance  the new value
     * @return this, for chaining, not null
     */
    public Builder absoluteTolerance(double absoluteTolerance) {
      ArgChecker.notNegativeOrZero(absoluteTolerance, "absoluteTolerance");
      this.absoluteTolerance = absoluteTolerance;
      return this;
    }

    /**
     * Sets the relative tolerance for the root finder.
     * @param relativeTolerance  the new value
     * @return this, for chaining, not null
     */
    public Builder relativeTolerance(double relativeTolerance) {
      ArgChecker.notNegativeOrZero(relativeTolerance, "relativeTolerance");
      this.relativeTolerance = relativeTolerance;
      return this;
    }

    /**
     * Sets the maximum number of steps for the root finder.
     * @param maximumSteps  the new value
     * @return this, for chaining, not null
     */
    public Builder maximumSteps(int maximumSteps) {
      ArgChecker.notNegativeOrZero(maximumSteps, "maximumSteps");
      this.maximumSteps = maximumSteps;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("RootFinderConfig.Builder{");
      buf.append("absoluteTolerance").append('=').append(JodaBeanUtils.toString(absoluteTolerance)).append(',').append(' ');
      buf.append("relativeTolerance").append('=').append(JodaBeanUtils.toString(relativeTolerance)).append(',').append(' ');
      buf.append("maximumSteps").append('=').append(JodaBeanUtils.toString(maximumSteps));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
