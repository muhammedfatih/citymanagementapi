import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CityPage } from '../model/city-page';
import { City } from '../model/city';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';

@Injectable()
export class CityService {

  private citiesUrl: string;

  constructor(private http: HttpClient) {
    this.citiesUrl = 'http://localhost:8080/cities';
  }

  public findAll(page: number, size: number, name: string): Observable<CityPage> {
    let params = new HttpParams().set("page", page.toString()).set("size", size.toString());
    if (name) {
      params = params.set("name", name);
    }
    return this.http.get<CityPage>(this.citiesUrl, { params }).pipe(map(res => res));
  }


  public save(city: City) {
    return this.http.post<City>(this.citiesUrl, city);
  }

  public update(id:number, city: City): Observable<City> {
    return this.http.put<City>(`${this.citiesUrl}/${id}`, city);
  }

  public findById(id: number): Observable<City> {
    return this.http.get<City>(`${this.citiesUrl}/${id}`);
  }
}
