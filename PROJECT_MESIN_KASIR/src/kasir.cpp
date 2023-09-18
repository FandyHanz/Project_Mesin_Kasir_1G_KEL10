#include <iostream>

int main(){
	std::string a,b;
	double[] harga={12500, 10000, 45000, 5000};
	
	std::cout<<"	|===================================|\n";
	std::cout<<"	|Selamat Datang di Resto Bunga Harum|\n";
	std::cout<<"	|===================================|\n";
	std::cout<<"	|berikut ini adalah list menu kami: |\n";
	std::cout<<"	|Nasi Goreng		: 12,500    |\n";
	std::cout<<"	|Ikan Goreng		: 10,000    |\n";
	std::cout<<"	|Ayam Goreng Utuh 	: 45,000    |\n";
	std::cout<<"	|				    |\n";
	std::cout<<"	|Minuman: 			    |\n";
	std::cout<<"	|Teh Tawar 		: 5,000     |\n";
	std::cout<<"	|===================================| \n";
	std::cout<<"											\n";
	std::cout<<" ingin pesan apa: \n";
	std::cin>> a;
	if( a=="nasi_goreng"){
		std::cout<<"harga : 	"<<harga[0] ; 
	}
	else if(a=="ikan_goreng"){
		std::cout<<"harga :		"<<harga[1];
	}
	else if(a=="ayam_goreng"){
		std::cout<<"harga :		"<<harga[2];	
	}
	std::cout<<"								\n";
	std::cout<<"Untuk minum nya mau pesan apa:	\n";
	std::cin>>b;
	if(b=="teh_tawar"){
		std::cout<<"harga :		"<<harga[3];
	}
	else{
		std::cout<<"maaf, stok benda tu kosong";
	}
	
     

	
}
