import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MakersComponent } from "./makers/makers";
import { ProductsComponent } from "./products/products";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MakersComponent, ProductsComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend-angular');
}
