package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

/**
 * Channels.
 *
 * Channels are hot communication primitives between coroutines. Capacity controls
 * buffering: rendezvous channels have no buffer, buffered channels can queue,
 * conflated channels keep the latest value, and unlimited channels keep growing.
 */
fun runChannelsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/channels"
    val channel = Channel<String>(capacity = Channel.BUFFERED)

    launch {
        channel.send("first")
        channel.send("second")
        channel.close()
    }

    for (value in channel) {
        logger.info(topic, "received=$value")
    }

    val left = Channel<String>(capacity = Channel.BUFFERED)
    val right = Channel<String>(capacity = Channel.BUFFERED)
    left.send("left-ready")
    right.send("right-ready")
    val selected = select {
        left.onReceive { it }
        right.onReceive { it }
    }
    logger.info(topic, "select received one ready value=$selected")
    left.close()
    right.close()

    /*
    Wrong:
    val channel = Channel<Event>(Channel.UNLIMITED)

    Why risky:
    Unlimited channels can grow without backpressure. Use a capacity that matches
    the event policy and memory limits.
    */
}
