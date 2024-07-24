package net.hareworks.developutil.entry.source

public abstract class EntrySource {
  abstract val type: EntrySourceType

  enum class EntrySourceType {
    HTTP,
    GIT_SSH,
    GIT_HTTP,
  }
}

public class Http : EntrySource {
  override val type = EntrySourceType.HTTP
  val url: String
  val basicAuth: String?

  constructor(url: String, basicAuth: String? = null) {
    this.url = url
    this.basicAuth = basicAuth
  }
}

public class GitHttp : EntrySource {
  override val type = EntrySourceType.GIT_HTTP
  val url: String
  val branch: String
  val path: String
  val username: String
  val password: String

  constructor(url: String, branch: String, path: String, username: String, password: String) {
    this.url = url
    this.branch = branch
    this.path = path
    this.username = username
    this.password = password
  }
}

public class GitSsh : EntrySource {
  override val type = EntrySourceType.GIT_SSH
  val url: String
  val branch: String
  val path: String
  val privateKey: String
  val publicKey: String

  constructor(url: String, branch: String, path: String, privateKey: String, publicKey: String) {
    this.url = url
    this.branch = branch
    this.path = path
    this.privateKey = privateKey
    this.publicKey = publicKey
  }
}
