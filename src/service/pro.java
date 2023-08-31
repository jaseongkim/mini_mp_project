package service;

import java.util.Scanner;

import dao.MemberInformationDAO;
import dto.MemberDTO;

public class pro {
	public int memberInformation(MemberDTO loginedId) {

		// public static void MemberInformation() {

		MemberInformationDAO dao = new MemberInformationDAO();
		// 커밋
		Scanner sc = new Scanner(System.in);

		System.out.println("회원 정보 수정");
		System.out.println("=====나의 정보=====");
		dao.ShowMember(loginedId.getId());

		while (true) {
			System.out.println("=================");
			System.out.println("작업 선택하세요 : 로그아웃 - 0, 비밀번호 변경 - 1, 이름 변경 - 2, "
					+ "전화번호 변경 - 3, 주소 변경 - 4,회원 탈퇴-5, 찜한 식당 확인하기 -6, 나가기 -7 ");
			String opt = sc.nextLine();
			// 뒤로 가기

			if (opt.equals("0")) {
				return 1;
				// 비밀번호 변경
			} else if (opt.equals("1")) {
				System.out.println("바꿀 비밀번호를 입력하세요");
				int opt1 = sc.nextInt();
				sc.nextLine(); // 개행 문자 소비

				dao.UpdatePwd(opt1, loginedId.getId());

				System.out.println("비밀번호가 변경되었습니다.");

				// 이름 변경

			} else if (opt.equals("2")) {
				System.out.println("바꿀 이름을 입력하세요");
				String opt1 = sc.nextLine();
				dao.UpdateName(loginedId.getId(), opt1);

				System.out.println("이름이 성공적으로 변경되었습니다.");

				// 전화번호 변경
			} else if (opt.equals("3")) {
				System.out.println("바꿀 번호를 입력하세요");
				String opt1 = sc.nextLine();
				dao.UpdateTel(loginedId.getId(), opt1);

				System.out.println("번호가 성공적으로 변경되었습니다.");

				// 주소 변경(시/도 변경만 가능)
			} else if (opt.equals("4")) {
				System.out.println("지역번호를 선택해주세요." + "1.서울/경기/인천 " + "2.강원도" + "3.충청도" + "4.경상도" + "5.전라도" + "6.제주도");

				int opt1 = sc.nextInt();
				sc.nextLine();

				dao.UpdateReg(opt1, loginedId.getId());

				System.out.println("지역번호가 성공적으로 변경되었습니다.");
				// sc.nextLine(); // 개행 문자 소비

			} else if (opt.equals("5")) {

				System.out.println("정말 탈퇴하시겠습니까? 정보 복구가 불가능합니다" + ": 네 - 1, 아니요 - 2 ");
				String opt1 = sc.nextLine();
				// 정보 삭제되면서, 처음화면으로
				if (opt1.equals("1")) {

					dao.DeleteMember(loginedId.getId());

					System.out.println("탈퇴 되었습니다, 감사합니다.");
					// 회원탈톼후 루프 종료
					return 1;
					// my page 이동
				} else if (opt1.equals("2")) {
					System.out.println("첫화면으로 돌아갑니다.");
					continue;
				}

			} else if (opt.equals("6")) {
				System.out.println("찜한 식당 확인하기 -0, 찜 삭제 - 1");
				System.out.println("============");
				String opt1 = sc.nextLine();
				System.out.println("======찜한 식당======");

				if (opt1.equals("0")) {
					dao.ShowWishList(loginedId.getId());
					System.out.println("불러오기 성공");
				}
				if (opt1.equals("1")) {
					System.out.println("삭제할 레스토랑 아이디를 적으십시오.");
					String opt2 = sc.nextLine();
					dao.DeleteWishList(opt2, loginedId.getId());
					System.out.println("찜삭제 성공");
				}
			} else if (opt.equals("7")) {
				return 0;
			} else {
				System.out.println("숫자를 다시 입력해주세요.");

			}
		}

	}
}
