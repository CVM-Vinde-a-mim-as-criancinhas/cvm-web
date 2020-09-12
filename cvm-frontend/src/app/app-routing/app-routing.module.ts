import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from '../component/dashboard/dashboard.component';
import {AgendaComponent} from '../component/agenda/agenda.component';
import {TransparenciaComponent} from '../component/transparencia/transparencia.component';
import {NoticiaComponent} from '../component/noticia/noticia.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'agenda', component: AgendaComponent},
  {path: 'transparencia', component: TransparenciaComponent},
  {path: 'noticia', component: NoticiaComponent},
  {path: '', pathMatch: 'full', redirectTo: 'dashboard'}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
