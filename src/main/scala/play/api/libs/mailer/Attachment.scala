package play.api.libs.mailer

import java.io.File


sealed trait Attachment

case class Email(subject: String,
                 from: String,
                 to: Seq[String] = Seq.empty,
                 bodyText: Option[String] = None,
                 bodyHtml: Option[String] = None,
                 charset: Option[String] = None,
                 cc: Seq[String] = Seq.empty,
                 bcc: Seq[String] = Seq.empty,
                 replyTo: Option[String] = None,
                 bounceAddress: Option[String] = None,
                 attachments: Seq[Attachment] = Seq.empty,
                 headers: Seq[(String, String)] = Seq.empty)

case class AttachmentFile(name: String,
                          file: File,
                          description: Option[String] = None,
                          disposition: Option[String] = None,
                          contentId: Option[String] = None) extends Attachment

case class AttachmentData(name: String,
                          data: Array[Byte],
                          mimetype: String,
                          description: Option[String] = None,
                          disposition: Option[String] = None,
                          contentId: Option[String] = None) extends Attachment
