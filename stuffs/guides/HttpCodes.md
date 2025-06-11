# HTTP Status Codes Guide for RESTful APIs

This document provides an overview of the most common HTTP status codes used in RESTful APIs, along with explanations of their meanings and when to use them.

---

## HTTP Status Code Table

| Code | Meaning               | Common Usage                      |
|------|-----------------------|-----------------------------------|
| 200  | OK                    | Successful request, data returned |
| 201  | Created               | Resource created successfully     |
| 204  | No Content            | Successful request with no body   |
| 400  | Bad Request           | Invalid or malformed data         |
| 401  | Unauthorized          | Authentication failure            |
| 403  | Forbidden             | Access denied                     |
| 404  | Not Found             | Resource not found                |
| 500  | Internal Server Error | Unexpected server error           |

---

## 1. Code 200 — OK
- **Description:** Indicates that the request was successful and the server returned the requested data.
- **Common Usage:** Used for successful read operations (`GET`) and successful updates (`PUT`).

---

## 2. Code 201 — Created
- **Description:** Indicates that a resource was successfully created on the server.
- **Common Usage:** Used after creation operations (`POST`) when a new resource is generated.

---

## 3. Code 400 — Bad Request
- **Description:** Indicates that the request contains invalid data or is malformed.
- **Common Usage:** Used when input data validation fails.

---

## 4. Code 404 — Not Found
- **Description:** Indicates that the requested resource was not found on the server.
- **Common Usage:** Used when attempting to access, update, or delete a non-existent resource.

---

## 5. Code 204 — No Content
- **Description:** The request was successful, but there is no content to return.
- **Common Usage:** Used after operations like `DELETE` or when there is no data to return.

---

## 6. Code 401 — Unauthorized
- **Description:** Indicates that authentication is required and has either failed or not been provided.
- **Common Usage:** Used for authentication failures in operations requiring login.

---

## 7. Code 403 — Forbidden
- **Description:** The server understood the request but refuses to authorize it.
- **Common Usage:** Used when a user lacks the proper permissions.

---

## 8. Code 500 — Internal Server Error
- **Description:** The server encountered an unexpected condition that prevented it from fulfilling the request.
- **Common Usage:** Used for unexpected server errors that cannot be specified.

---

## Best Practices for Using HTTP Status Codes

- Use **2xx** codes to indicate success.
- Use **4xx** codes to indicate client-side errors (invalid input, resource not found, authentication).
- Use **5xx** codes to indicate server-side errors.
- Always provide clear and standardized error messages in the response body.
- Document all codes used so that API consumers know what to expect.

---

## References

- [RFC 7231 — Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content](https://tools.ietf.org/html/rfc7231)
- [REST API Tutorial — HTTP Status Codes](https://restfulapi.net/http-status-codes/)
- [MDN Web Docs - HTTP response status codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

---