
export const LANGUAGE = 'language'


export function sessionSet(key: string, value: string) {
  return sessionStorage.setItem(key, value)
}

export function sessionGet(key: string) {
  return sessionStorage.getItem(key)
}


export function localSet(key: string, value: string) {
  return localStorage.setItem(key, value)
}

export function localGet(key: string) {
  return localStorage.getItem(key)
}
