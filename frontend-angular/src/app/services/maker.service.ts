import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Maker } from '../models/maker';

@Injectable({
  providedIn: 'root'  // hace que el servicio sea singleton y accesible en toda la app
})
export class MakerService {
  private apiUrl = 'http://localhost:8080/api/maker'; // URL de tu backend

  constructor(private http: HttpClient) {}

  // GET: obtener todos los makers
  getAll(): Observable<Maker[]> {
    return this.http.get<Maker[]>(`${this.apiUrl}/find`);
  }

  // GET: obtener un maker por id
  getById(id: number): Observable<Maker> {
    return this.http.get<Maker>(`${this.apiUrl}/${id}`);
  }

  // POST: crear un nuevo maker
  create(maker: Maker): Observable<Maker> {
    return this.http.post<Maker>(this.apiUrl, maker);
  }

  // PUT: actualizar un maker existente
  update(id: number, maker: Maker): Observable<Maker> {
    return this.http.put<Maker>(`${this.apiUrl}/${id}`, maker);
  }

  // DELETE: eliminar un maker por id
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
