const URI_START = 'http://localhost:8080';

// simulate an enumeration by freezing an object
const ContentType = {
  JSON: 'application/json',
  TEXT: 'text/plain',
  FORM: 'multipart/form-data'
}
Object.freeze(ContentType);

class HTTPRequest {

  async get(path) {
    return await fetch(URI_START + path);
  }

  async post(path, contentType, body) {
    return await fetch(URI_START + path, {
      method: 'POST',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async put(path, contentType, body) {
    return await fetch(URI_START + path, {
      method: 'PUT',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async patch(path, contentType, body) {
    return await fetch(URI_START + path, {
      method: 'PATCH',
      headers: {
        'Content-Type': contentType
      },
      body: body
    });
  }

  async delete(path) {
    return await fetch(URI_START + path, {
      method: 'DELETE'
    });
  }
}

export {HTTPRequest, ContentType}