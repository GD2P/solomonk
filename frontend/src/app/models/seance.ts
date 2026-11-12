import {Serie} from './serie';

export interface Seance {
  id: number;
  date: string;
  seanceTypeNom: string;
  series: Serie[];
}
