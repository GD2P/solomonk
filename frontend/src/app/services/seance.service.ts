import {Observable} from 'rxjs';
import {SeanceType} from '../models/seance-type';
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ExercicePrevu} from '../models/exercice-prevu';
import {Seance} from '../models/seance';
import {CreerSeanceRequest} from '../models/creer-seance-request';

@Injectable({
  providedIn: 'root',
})
export class SeanceService {
  private http = inject(HttpClient);
  getSeanceTypes(): Observable<SeanceType[]> {
    return this.http.get<SeanceType[]>('/api/seance-types');
  }
  getExercicesPrevus(seanceTypeId: number): Observable<ExercicePrevu[]>{
    return this.http.get<ExercicePrevu[]>(`/api/seance-types/${seanceTypeId}/exercices-prevus`);
  }
  getSeances():Observable<Seance[]>{
    return this.http.get<Seance[]>('/api/seances');
  }
  creerSeance(request: CreerSeanceRequest): Observable<Seance>{
    return this.http.post<Seance>('/api/seances',request);
  }
}
