// simulate an enumeration by freezing an object
const ContentType = {
  JSON: 'application/json',
  TEXT: 'text/plain',
  FORM: 'multipart/form-data'
}
Object.freeze(ContentType);

class HTTPRequest {

  async get(path) {
    await fetch(path);
  }

  async post(path, contentType, body) {
    await fetch(path, {
      method: 'POST',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async put(path, contentType, body) {
    await fetch(path, {
      method: 'PUT',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async patch(path, contentType, body) {
    await fetch(path, {
      method: 'patch',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async delete(path) {
    await fetch(path, {
      method: 'DELETE'
    });
  }
}

export {HTTPRequest, ContentType}