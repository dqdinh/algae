package algae.fs2.kafka

import cats.data.NonEmptyList
import fs2.Stream
import fs2.kafka.CommittableMessage

trait KafkaConsumer[F[_], K, V] {
  def stream: Stream[F, CommittableMessage[F, K, V]]

  def partitionedStream: Stream[F, Stream[F, CommittableMessage[F, K, V]]]

  def subscribe(topics: NonEmptyList[String]): Stream[F, Unit]
}
