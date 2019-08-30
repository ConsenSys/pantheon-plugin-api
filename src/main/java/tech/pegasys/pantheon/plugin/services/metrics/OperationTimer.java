/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.pantheon.plugin.services.metrics;

import java.io.Closeable;

/** An interface for a timer that records duration of operations for metrics purposes. */
public interface OperationTimer {

  /**
   * Starts the timer.
   *
   * @return The produced TimingContext.
   */
  TimingContext startTimer();

  /** An interface for stopping the timer and returning elapsed time. */
  interface TimingContext extends Closeable {

    /**
     * Stops the timer and returns the elapsed time.
     *
     * @return Elapsed time in seconds.
     */
    double stopTimer();

    @Override
    default void close() {
      stopTimer();
    }
  }
}
