import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http";
import { BehaviorSubject, Observable } from "rxjs";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url="http://localhost:3000/"
  currentUserSubject: BehaviorSubject<any>

  constructor(private http:HttpClient) {
    console.log("El servicio de autenticación está corriendo")
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('current') || '{}'))
  }

  login(credentials:any):Observable<any> {
    return this.http.post(this.url+'login', credentials).pipe(map(data =>{
      sessionStorage.setItem('currentUser', JSON.stringify(data));
      this.currentUserSubject.next(data)
      return data;
    }))
  }

  signIn(credentials:any):Observable<any> {
    return this.http
      .post<any>(this.url+'signin', credentials);
  }

  get AuthenticatedUser() {
    return this.currentUserSubject.value
  }
}
