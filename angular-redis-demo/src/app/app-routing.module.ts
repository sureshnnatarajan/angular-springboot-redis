import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListDemoComponent } from './redis-practice/list-demo/list-demo.component';
import { SetDemoComponent } from './redis-practice/set-demo/set-demo.component';
import { SortedSetDemoComponent } from './redis-practice/sorted-set-demo/sorted-set-demo.component';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
