package com.hariofspades.randomusers.common.scheduling

import android.os.Looper

internal class AndroidPreconditions {

    companion object {

        /**
         * Asserts that the current thread is a worker thread.
         */
        internal fun assertWorkerThread() {
            if (isMainThread()) {
                throw IllegalStateException(
                        "This task must be run on a worker thread and not on the Main thread.")
            }
        }

        /**
         * Asserts that the current thread is the Main Thread.
         */
        fun assertUiThread() {
            if (!isMainThread()) {
                throw IllegalStateException(
                        "This task must be run on the Main thread and not on a worker thread.")
            }
        }

        /**
         * Returns whether the current thread is the Android main thread
         *
         * @return true if the current thread is the main thread, otherwise; false.
         */
        fun isMainThread(): Boolean {
            return Looper.getMainLooper().thread == Thread.currentThread()
        }
    }
}