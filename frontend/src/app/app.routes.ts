import { Routes } from '@angular/router';
import {SeanceList} from './pages/seance-list/seance-list';

export const routes: Routes = [
  { path: '', redirectTo: 'seances', pathMatch: 'full' },
  { path: 'seances', component: SeanceList },
];
