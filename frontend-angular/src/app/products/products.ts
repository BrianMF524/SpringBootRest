import { Component,OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { NgForOf } from "@angular/common";

@Component({
  selector: 'app-products',
  standalone:true,
  imports: [NgForOf],
  templateUrl: './products.html',
  styleUrl: './products.scss'
})
export class ProductsComponent implements OnInit {
  products:any[]=[];

  constructor(private productService: ProductService){}

  ngOnInit():void{
    this.productService.getAll().subscribe({
      next:(data)=>{
        this.products=data;
      },
      error:(err)=>{
        console.log("Error ",err);
      }
    })
  }

}
