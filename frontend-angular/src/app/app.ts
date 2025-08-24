import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MakersComponent } from "./makers/makers";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MakersComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend-angular');
}
