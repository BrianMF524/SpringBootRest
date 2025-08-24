import { Component, OnInit } from '@angular/core';
import { MakerService } from '../services/maker.service';
import { NgForOf } from "@angular/common";

@Component({
  selector: 'app-makers',
  standalone:true,
  imports: [NgForOf],
  templateUrl: './makers.html',
  styleUrl: './makers.scss'
})
export class MakersComponent implements OnInit{
  makers:any[]=[];

  constructor(private makerService: MakerService){}

  ngOnInit(): void {
      this.makerService.getAll().subscribe({
        next:(data)=>{
          this.makers=data;
        },
        error:(err)=>{
          console.log("error:",err);
        }
      })
  }
}
