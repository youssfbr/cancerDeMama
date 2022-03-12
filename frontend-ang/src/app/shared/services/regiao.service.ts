import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';

import { Regiao } from './../models/regiao';

import { environment } from 'src/environments/environment';

@Injectable()
export class RegiaoService {

  apiUrl: string = environment.apiURLBase + '/api/v1/regioes';

  constructor(private http: HttpClient) { }

  getRegioes(): Observable<Regiao[]> {
    return this.http
      .get<Regiao[]>(this.apiUrl)
      .pipe(take(1));
  }

  getRegioesById(id: number): Observable<Regiao> {
    return this.http
      .get<Regiao>(`${this.apiUrl}/${id}`)
      .pipe(take(1));
  }

  persist(regiao: Regiao): Observable<Regiao> {
    return regiao.id
      ? this.http.put<Regiao>(`${this.apiUrl}/${regiao.id}`, regiao).pipe(take(1))
      : this.http.post<Regiao>(this.apiUrl, regiao).pipe(take(1));
  }

  delete(regiao: Regiao): Observable<any> {
    return this.http
      .delete<any>(`${this.apiUrl}/${regiao.id}`)
      .pipe(take(1));
  }

}
