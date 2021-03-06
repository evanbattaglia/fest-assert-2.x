/*
 * Created on Dec 20, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.assertions.core.EnumerableAssert;
import org.fest.assertions.data.Index;
import org.fest.assertions.description.Description;
import org.fest.assertions.internal.FloatArrays;
import org.fest.util.VisibleForTesting;

/**
 * Assertion methods for arrays of {@code float}s.
 * <p>
 * To create an instance of this class, invoke {@link Assertions#assertThat(float[])}.
 * </p>
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class FloatArrayAssert extends AbstractAssert<FloatArrayAssert, float[]> implements
    EnumerableAssert<FloatArrayAssert> {

  @VisibleForTesting
  FloatArrays arrays = FloatArrays.instance();

  protected FloatArrayAssert(float[] actual) {
    super(actual, FloatArrayAssert.class);
  }

  protected FloatArrayAssert(float[] actual, Description description) {
    super(actual, FloatArrayAssert.class, description);
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isNullOrEmpty() {
    arrays.assertNullOrEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isEmpty() {
    arrays.assertEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isNotEmpty() {
    arrays.assertNotEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert hasSize(int expected) {
    arrays.assertHasSize(description, actual, expected);
    return this;
  }

  /**
   * Verifies that the given array contains the given value at the given index.
   *
   * @param value the value to look for.
   * @param index the index where the value should be stored in the given array.
   * @return {@code this} assertion object.
   * @throws AssertionError if the given array is {@code null} or empty.
   * @throws NullPointerException if the given {@code Index} is {@code null}.
   * @throws IndexOutOfBoundsException if the value of the given {@code Index} is equal to or greater than the size of
   *           the given array.
   * @throws AssertionError if the given array does not contain the given value at the given index.
   */
  public FloatArrayAssert contains(float value, Index index) {
    arrays.assertContains(description, actual, value, index);
    return this;
  }

  /**
   * Verifies that the given array does not contain the given value at the given index.
   *
   * @return {@code this} assertion object.
   * @param value the value to look for.
   * @param index the index where the value should be stored in the given array.
   *
   * @throws AssertionError if the given array is {@code null}.
   * @throws NullPointerException if the given {@code Index} is {@code null}.
   * @throws AssertionError if the given array contains the given value at the given index.
   */
  public FloatArrayAssert doesNotContain(float value, Index index) {
    arrays.assertDoesNotContain(description, actual, value, index);
    return this;
  }

  /**
   * Verifies that the actual array contains the given values, in any order.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values.
   */
  public FloatArrayAssert contains(float... values) {
    arrays.assertContains(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains only the given values and nothing else, in any order.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values, i.e. the actual array contains some
   *           or none of the given values, or the actual array contains more values than the given ones.
   */
  public FloatArrayAssert containsOnly(float... values) {
    arrays.assertContainsOnly(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains the given sequence, without any other values between them.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the given array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given sequence.
   */
  public FloatArrayAssert containsSequence(float... sequence) {
    arrays.assertContainsSequence(description, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array does not contain the given values.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains any of the given values.
   */
  public FloatArrayAssert doesNotContain(float... values) {
    arrays.assertDoesNotContain(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array does not contain duplicates.
   *
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains duplicates.
   */
  public FloatArrayAssert doesNotHaveDuplicates() {
    arrays.assertDoesNotHaveDuplicates(description, actual);
    return this;
  }

  /**
   * Verifies that the actual array starts with the given sequence of values, without any other values between them.
   * Similar to <code>{@link #containsSequence(float...)}</code>, but it also verifies that the first element in the
   * sequence is also first element of the actual array.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not start with the given sequence.
   */
  public FloatArrayAssert startsWith(float... sequence) {
    arrays.assertStartsWith(description, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array ends with the given sequence of values, without any other values between them.
   * Similar to <code>{@link #containsSequence(float...)}</code>, but it also verifies that the last element in the
   * sequence is also last element of the actual array.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not end with the given sequence.
   */
  public FloatArrayAssert endsWith(float... sequence) {
    arrays.assertEndsWith(description, actual, sequence);
    return this;
  }
}
