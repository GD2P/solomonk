import {Component, inject, signal} from '@angular/core';
import {DatePipe} from '@angular/common';
import {RouterLink} from '@angular/router';
import {SeanceService} from '../../services/seance.service';
import {Seance} from '../../models/seance';

@Component({
  selector: 'app-seance-list',
  imports: [DatePipe, RouterLink],
  templateUrl: './seance-list.html',
  styleUrl: './seance-list.css',
})
export class SeanceList {
  private seanceService = inject(SeanceService);
  seances = signal<Seance[]>([]);
  constructor() {
    this.seanceService.getSeances().subscribe(data => {
      this.seances.set(data);
    });
  }
}
