export function sanitizeInput(input) {
  const pattern = /^[a-zA-Z0-9\s\-_/]+$/
  return pattern.test(input);
}