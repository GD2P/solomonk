import {SerieRequest} from './serie-request';

export interface CreerSeanceRequest {
  seanceTypeId: number;
  date: string;
  series: SerieRequest[];
}
