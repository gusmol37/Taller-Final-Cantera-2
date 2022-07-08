import {Injectable} from '@angular/core';
import {RolledNumberInterface} from "../models/rolled-number-interface";
import {CardDetailInterface} from "../models/card-detail-interface";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/';
  }

  getNumberList(): Observable<RolledNumberInterface[]> {
    return this.http.get<RolledNumberInterface[]>(this.url + 'rollednumber');
  }

  getCardDetailList(): Observable<CardDetailInterface[]> {
    return this.http.get<CardDetailInterface[]>(this.url + 'carddetail');
  }
}
