USE [master]
GO
/****** Object:  Database [MMS]    Script Date: 05/29/2018 11:19:28 ******/
CREATE DATABASE [MMS] ON  PRIMARY 
( NAME = N'MMS', FILENAME = N'D:\迅雷下载\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\MMS.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MMS_log', FILENAME = N'D:\迅雷下载\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\MMS_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MMS] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MMS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MMS] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [MMS] SET ANSI_NULLS OFF
GO
ALTER DATABASE [MMS] SET ANSI_PADDING OFF
GO
ALTER DATABASE [MMS] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [MMS] SET ARITHABORT OFF
GO
ALTER DATABASE [MMS] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [MMS] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [MMS] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [MMS] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [MMS] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [MMS] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [MMS] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [MMS] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [MMS] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [MMS] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [MMS] SET  DISABLE_BROKER
GO
ALTER DATABASE [MMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [MMS] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [MMS] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [MMS] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [MMS] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [MMS] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [MMS] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [MMS] SET  READ_WRITE
GO
ALTER DATABASE [MMS] SET RECOVERY FULL
GO
ALTER DATABASE [MMS] SET  MULTI_USER
GO
ALTER DATABASE [MMS] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [MMS] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'MMS', N'ON'
GO
USE [MMS]
GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 05/29/2018 11:19:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserInfo](
	[UserID] [char](10) NOT NULL,
	[UserName] [varchar](30) NOT NULL,
	[PassWord] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[UserInfo] ([UserID], [UserName], [PassWord]) VALUES (N'D201821102', N'Doctor', N'666')
INSERT [dbo].[UserInfo] ([UserID], [UserName], [PassWord]) VALUES (N'N201821101', N'Nurse', N'666')
INSERT [dbo].[UserInfo] ([UserID], [UserName], [PassWord]) VALUES (N'P201821101', N'Patient', N'666')
INSERT [dbo].[UserInfo] ([UserID], [UserName], [PassWord]) VALUES (N'P201821102', N'Patient', N'666')
/****** Object:  Table [dbo].[PushInfo]    Script Date: 05/29/2018 11:19:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PushInfo](
	[DiseasesID] [char](10) NOT NULL,
	[DiseasesName] [varchar](30) NOT NULL,
	[HealthInformation] [ntext] NULL,
	[PushContent] [nvarchar](200) NULL,
	[PushImage] [image] NULL,
PRIMARY KEY CLUSTERED 
(
	[DiseasesID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18001', N'内科', N'资料讲解：
1.如果想当天完成胃镜、腹部B超、上消化道钡餐等检查，请当天早上禁食、禁水；
2.当天肯定不能完成结肠镜检查，因为需要肠道准备；
3.请不要忘记带上你近期检查报告（可以避免一些不必要的检查）；
4.可以选择下午来看门诊，因为上午门诊患者实在太多了；
5.胃食管反流病专病门诊一般为周三下午；
6.需要内镜下治疗胃息肉、肠息肉，可以通过好大夫提前将资料发给有空的专家看，说不定专家可以提前预约你住院，减轻看病的流程，（内镜---专家门诊----住院登记-----回家待床------入院）；
7.胶囊内镜也是需要预约的，因为它一天只能检查一名患者，而且也需要行肠道准备；', N'内镜下治疗（1.服用阿司匹林等抗凝药物尽量停药2周；2.女性患者需避开经期）
无痛内镜检查当天避免驾车，最好有一名家属陪同；', NULL)
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18002', N'外科', N'外科注意：
泌尿系疾病即泌尿系统组成器官所患疾病，泌尿系统各器官(肾脏、输尿管、膀胱、尿道)都可发生疾病，并波及整个系统。泌尿系统的疾病既可由身体其他系统病变引起，又可影响其他系统甚至全身。 泌尿系统具体疾病就医指南，请查看外科疾病列表中泌尿外科部分和内科疾病列表中肾内科部分。 其主要表现在泌尿系统本身，如排尿改变、尿的改变、肿块、疼痛等，但亦可表现在其他方面，如高血压、水肿、贫血等。泌尿系统疾病的性质，多数和其他系统疾病类似，包括先天性畸形、感染、免疫机制、遗传、损伤、肿瘤等；但又有其特有的疾病，如肾小球肾炎、尿石症、肾功能衰竭等。在泌尿科临床中，必须时刻联系全身状况来考虑问题。', N'泌尿系统具体疾病就医指南，请查看外科疾病列表中泌尿外科部分和内科疾病列表中肾内科部分。', NULL)
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18003', N'骨外科', N'骨科注意：
现在很多的年轻人都非常热爱街舞，但是有一些人在跳街舞的时候总是受伤，甚至还有的人在跳街舞的过程中骨折了，从而让自己的身体受到了很大的伤害，而且骨折也会严重影响人们的日常生活，那么骨折患者在日常生活当中应该怎么样去护理自己的身体呢?
严重骨折、下肢骨折、牵引、手术、截肢、截瘫等病人生活自理能力均有不同程度的下降。
护理措施：
(1)在生活上热情关心病人，尽量满足病人的生活要求，取得病人的信任和依赖。
(2)认真帮助病人饮水、进食、排便、翻身、读书、阅报，直至能生活自理。
(3)做好病室、病床、口腔及皮肤的清洁卫生工作，定期为病人擦浴、洗头、剪指甲、更换衣服床单，使病人感到舒适。
(4)对长期卧床病人，定时翻身、按摩、做好皮肤护理。
(5)注意调节饮食，加强营养。
(6)积极鼓励、协助病人功能锻炼和生活训练，使其早日能够生活自理。', N'不管人们是做什么运动，都一定要先保障自己的健康，一定不能让自己受伤，更加不能让自己骨折，因为骨折这个疾病会严重影响人们的工作效率，让人们有很多的事情都不能去做，同时每一位骨折患者都应该好好的接受治疗，那样才可以尽快的恢复正常生活。', NULL)
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18004', N'管理科', N'撸起袖子加油干，别出岔子。', N'富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善。', NULL)
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18005', N'专科', N'资料讲解：
1.如果想当天完成胃镜、腹部B超、上消化道钡餐等检查，请当天早上禁食、禁水；
2.当天肯定不能完成结肠镜检查，因为需要肠道准备；
3.请不要忘记带上你近期检查报告（可以避免一些不必要的检查）；
4.可以选择下午来看门诊，因为上午门诊患者实在太多了；
5.胃食管反流病专病门诊一般为周三下午；
6.需要内镜下治疗胃息肉、肠息肉，可以通过好大夫提前将资料发给有空的专家看，说不定专家可以提前预约你住院，减轻看病的流程，（内镜---专家门诊----住院登记-----回家待床------入院）；
7.胶囊内镜也是需要预约的，因为它一天只能检查一名患者，而且也需要行肠道准备；', N'内镜下治疗（1.服用阿司匹林等抗凝药物尽量停药2周；2.女性患者需避开经期）
无痛内镜检查当天避免驾车，最好有一名家属陪同；', NULL)
INSERT [dbo].[PushInfo] ([DiseasesID], [DiseasesName], [HealthInformation], [PushContent], [PushImage]) VALUES (N'disea18006', N'医技', N'资料讲解：
1.如果想当天完成胃镜、腹部B超、上消化道钡餐等检查，请当天早上禁食、禁水；
2.当天肯定不能完成结肠镜检查，因为需要肠道准备；
3.请不要忘记带上你近期检查报告（可以避免一些不必要的检查）；
4.可以选择下午来看门诊，因为上午门诊患者实在太多了；
5.胃食管反流病专病门诊一般为周三下午；
6.需要内镜下治疗胃息肉、肠息肉，可以通过好大夫提前将资料发给有空的专家看，说不定专家可以提前预约你住院，减轻看病的流程，（内镜---专家门诊----住院登记-----回家待床------入院）；
7.胶囊内镜也是需要预约的，因为它一天只能检查一名患者，而且也需要行肠道准备；', N'内镜下治疗（1.服用阿司匹林等抗凝药物尽量停药2周；2.女性患者需避开经期）
无痛内镜检查当天避免驾车，最好有一名家属陪同；', NULL)
/****** Object:  Table [dbo].[PostInfo]    Script Date: 05/29/2018 11:19:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PostInfo](
	[PostID] [char](10) NOT NULL,
	[PostName] [varchar](30) NOT NULL,
	[Rank] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18001', N'管理岗位', N'院长')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18002', N'管理岗位', N'副院长')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18003', N'管理岗位', N'副院长')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18004', N'管理岗位', N'人事科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18005', N'管理岗位', N'财务科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18006', N'管理岗位', N'医务科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18007', N'管理岗位', N'护理部')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18008', N'管理岗位', N'信息科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18009', N'管理岗位', N'设备科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postm18010', N'管理岗位', N'保卫科')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18001', N'专业技术岗位', N'正高级岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18002', N'专业技术岗位', N'副高级岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18003', N'专业技术岗位', N'中级岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18004', N'专业技术岗位', N'初级岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18005', N'专业技术岗位', N'员级岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18006', N'专业内科技术岗位', N'高级内科岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18007', N'专业外科科技术岗位', N'高外科术岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18008', N'专业专科技术岗位', N'高级专科岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postt18009', N'专业医技技术岗位', N'高级医技岗位')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postw18001', N'工勤技能岗位', N'高级技师')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postw18002', N'工勤技能岗位', N'技师')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postw18003', N'工勤技能岗位', N'高级工')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postw18004', N'工勤技能岗位', N'中级工')
INSERT [dbo].[PostInfo] ([PostID], [PostName], [Rank]) VALUES (N'postw18005', N'工勤技能岗位', N'初级工')
/****** Object:  Table [dbo].[PatientInfo]    Script Date: 05/29/2018 11:19:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PatientInfo](
	[PatientID] [char](10) NOT NULL,
	[PatientName] [varchar](30) NOT NULL,
	[GENDER] [varchar](2) NOT NULL,
	[BIRTHDAY] [date] NOT NULL,
	[IDNumber] [char](18) NOT NULL,
	[PhoneNumber] [char](11) NOT NULL,
	[Address] [varchar](50) NULL,
	[Avatar_P] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821101', N'头病人', N'男', CAST(0xFF0E0B00 AS Date), N'100201198504055248', N'17672121000', N'xx省xx市xx区xx街道xx号', NULL)
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821102', N'神病人', N'男', CAST(0x3F0C0B00 AS Date), N'100201198305025248', N'17672121033', N'xx省xx市xx区xx街道xx号', NULL)
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821103', N'外病人', N'女', CAST(0x1A0F0B00 AS Date), N'100201198505025246', N'17672121066', N'xx省xx市xx区xx街道xx号', NULL)
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821104', N'酒病人', N'男', CAST(0x79050B00 AS Date), N'100201197808025258', N'17672121077', N'xx省xx市xx区xx街道xx号', NULL)
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821105', N'孕病人', N'女', CAST(0xA6100B00 AS Date), N'100201198606025228', N'17672121088', N'xx省xx市xx区xx街道xx号', NULL)
INSERT [dbo].[PatientInfo] ([PatientID], [PatientName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [Avatar_P]) VALUES (N'P201821106', N'手病人', N'男', CAST(0x091F0B00 AS Date), N'100201199607025278', N'17672121099', N'xx省xx市xx区xx街道xx号', NULL)
/****** Object:  Table [dbo].[DepartInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DepartInfo](
	[DEPARTID] [char](10) NOT NULL,
	[DEPARTNAME] [varchar](30) NOT NULL,
	[DEPARTTEL] [char](11) NOT NULL,
	[PostID] [char](10) NOT NULL,
	[DiseasesID] [char](10) NOT NULL,
	[Introduce] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[DEPARTID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821101', N'院长室', N'17672110111', N'postm18001', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821102', N'副院长室', N'17672110222', N'postm18002', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821103', N'人事科', N'17672110333', N'postm18004', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821104', N'财务科', N'17672110444', N'postm18005', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821105', N'医务科', N'17672110555', N'postm18006', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821106', N'护理部', N'17672110666', N'postm18007', N'disea18004', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821107', N'神经内科', N'17672110777', N'postt18001', N'disea18001', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821201', N'消化内科', N'17672120111', N'postt18001', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821202', N'肾脏内科', N'17672120222', N'postt18001', N'disea18001', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821203', N'心血管内科', N'17672120333', N'postt18001', N'disea18001', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821204', N'呼吸内科', N'17672120444', N'postt18001', N'disea18001', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821205', N'血液内科', N'17672120555', N'postt18001', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821206', N'内分泌科', N'17672120666', N'postt18001', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821207', N'风湿免疫科', N'17672120777', N'postt18001', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821208', N'勤工高级科', N'17672120888', N'postw18002', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821209', N'勤工中级科', N'17672120999', N'postw18003', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821210', N'勤工科', N'17672121000', N'postw18003', N'disea18003', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821211', N'普通外科', N'17672121001', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821212', N'心胸外科', N'17672121002', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821213', N'神经外科', N'17672121003', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821214', N'骨科', N'17672121004', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821215', N'放射性治疗', N'17672121005', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821216', N'泌尿外科', N'17672121023', N'postt18007', N'disea18002', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821217', N'儿科', N'17672121006', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821218', N'眼科', N'17672121007', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821219', N'儿科', N'17672121008', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821220', N'中西结合科', N'17672121009', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821221', N'耳鼻喉科', N'17672121010', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821222', N'口腔科', N'17672121011', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821223', N'皮肤科', N'17672121012', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821224', N'空勤科', N'17672121013', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821225', N'感染内科', N'17672121014', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821226', N'麻醉科', N'17672121015', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821227', N'干部病房一科', N'17672121016', N'postt18008', N'disea18005', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821228', N'门诊科', N'17672121017', N'postt18009', N'disea18006', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821229', N'急诊科', N'17672121018', N'postt18009', N'disea18006', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821230', N'保健科', N'17672121019', N'postt18009', N'disea18006', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821231', N'体检中心', N'17672121020', N'postt18009', N'disea18006', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821232', N'临床药理科', N'17672121021', N'postt18009', N'disea18006', NULL)
INSERT [dbo].[DepartInfo] ([DEPARTID], [DEPARTNAME], [DEPARTTEL], [PostID], [DiseasesID], [Introduce]) VALUES (N'K201821233', N'医学工程科', N'17672121022', N'postt18009', N'disea18006', NULL)
/****** Object:  Table [dbo].[BedInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BedInfo](
	[BedID] [char](10) NOT NULL,
	[WARDID] [varchar](5) NOT NULL,
	[WardBedNum] [varchar](5) NOT NULL,
	[BedPrice] [money] NOT NULL,
	[DEPARTID] [char](10) NOT NULL,
	[Address] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[BedID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821101', N'21101', N'4', 300.0000, N'K201821101', N'一楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821102', N'21101', N'4', 300.0000, N'K201821101', N'一楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821103', N'21101', N'4', 300.0000, N'K201821101', N'一楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821104', N'21101', N'4', 300.0000, N'K201821101', N'一楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821105', N'21201', N'2', 600.0000, N'K201821101', N'二楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821201', N'21201', N'2', 600.0000, N'K201821208', N'二楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821202', N'21301', N'2', 600.0000, N'K201821208', N'三楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821203', N'21301', N'2', 600.0000, N'K201821208', N'三楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821204', N'21401', N'2', 600.0000, N'K201821208', N'四楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821205', N'21401', N'2', 600.0000, N'K201821208', N'四楼第一个房间')
INSERT [dbo].[BedInfo] ([BedID], [WARDID], [WardBedNum], [BedPrice], [DEPARTID], [Address]) VALUES (N'W201821206', N'21501', N'2', 600.0000, N'K201821106', N'四楼第一个房间')
/****** Object:  Table [dbo].[HspPriceInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HspPriceInfo](
	[ProjectID] [char](10) NOT NULL,
	[ProjectName] [varchar](30) NOT NULL,
	[Specification] [varchar](10) NOT NULL,
	[Unit] [varchar](5) NOT NULL,
	[Price] [money] NOT NULL,
	[DepartID] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProjectID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00001', N'挂号费', N'次', N'次', 0.5000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00002', N'一般医师', N'人', N'次', 1.5000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00003', N'主治医师', N'人', N'次', 2.5000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00004', N'副主任医师', N'人', N'次', 5.5000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00005', N'主任医师', N'人', N'次', 7.5000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00006', N'知名专家门诊诊查费', N'人', N'次', 50.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00007', N'急诊诊查费', N'人', N'次', 1.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00008', N'门急诊留观诊查费', N'人', N'次', 10.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00009', N'住院诊查费', N'人', N'次', 5.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00010', N'急诊监护费', N'人', N'次', 60.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00011', N'院前急救费', N'人', N'次', 35.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00012', N'体检费', N'人', N'次', 25.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00013', N'救护车费', N'人', N'次', 10.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00014', N'病房取暖费', N'人', N'次', 3.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00015', N'普通病房床位费', N'人', N'次', 20.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00016', N'会诊费', N'人', N'次', 100.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00017', N'护理费', N'人', N'次', 15.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00018', N'抢救费', N'人', N'次', 120.0000, N'K201821104')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00019', N'中心吸氧', N'人', N'次', 3.0000, N'K201821107')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00020', N'肌肉注射', N'人', N'次', 2.0000, N'K201821107')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00021', N'胰岛素注射', N'人', N'次', 2.0000, N'K201821107')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00022', N'X线透视检查', N'人', N'次', 5.0000, N'K201821107')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00023', N'X线摄影', N'人', N'次', 13.0000, N'K201821201')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00024', N'单脏器B超检查', N'人', N'次', 20.0000, N'K201821201')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00025', N'B超常规检查', N'人', N'次', 40.0000, N'K201821202')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00026', N'经阴道B超检查', N'人', N'次', 70.0000, N'K201821202')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00027', N'彩色多普勒超声常规检查', N'人', N'次', 120.0000, N'K201821202')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00028', N'浅表器官彩色多普勒超声检查', N'人', N'次', 90.0000, N'K201821202')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00029', N'心脏彩色多普勒超声', N'人', N'次', 260.0000, N'K201821203')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00030', N'左心功能测定', N'人', N'次', 40.0000, N'K201821203')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00031', N'黑白热敏打印照片', N'人', N'张', 5.0000, N'K201821203')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00032', N'彩色打印照片', N'人', N'张', 8.0000, N'K201821203')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00033', N'彩色胶片照相', N'人', N'张', 10.0000, N'K201821203')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00034', N'血红蛋白测定(Hb)', N'人', N'次', 1.0000, N'K201821204')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00035', N'红细胞计数(RBC)', N'人', N'次', 1.0000, N'K201821204')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00036', N'红细胞沉降率测定(ESR)', N'人', N'次', 3.0000, N'K201821204')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00037', N'白细胞计数(WBC)', N'人', N'次', 1.0000, N'K201821205')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00038', N'白细胞分类计数(DC)', N'人', N'次', 2.0000, N'K201821205')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00039', N'嗜酸性粒细胞直接计数', N'人', N'次', 1.0000, N'K201821205')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00040', N'血小板计数', N'人', N'次', 1.0000, N'K201821206')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00041', N'血细胞分析', N'人', N'次', 10.0000, N'K201821206')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00042', N'出血时间测定(BT)', N'人', N'次', 1.0000, N'K201821206')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00043', N'凝血时间测定(CT)', N'人', N'次', 1.0000, N'K201821206')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00044', N'血浆渗量试验', N'人', N'次', 3.0000, N'K201821207')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00045', N'血常规（手工法）', N'人', N'次', 6.0000, N'K201821207')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00046', N'血常规（三分群）', N'人', N'次', 13.0000, N'K201821207')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00047', N'血常规（五分群）', N'人', N'次', 20.0000, N'K201821207')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00048', N'尿常规检查', N'人', N'次', 3.0000, N'K201821208')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00049', N'尿妊娠试验', N'人', N'次', 5.0000, N'K201821208')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00050', N'尿红细胞位相', N'人', N'次', 6.0000, N'K201821209')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00051', N'尿常规(机器法)', N'人', N'次', 10.0000, N'K201821209')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00052', N'粪便常规(手工法)', N'人', N'次', 3.0000, N'K201821209')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00053', N'粪便常规(机器 法)', N'人', N'次', 12.0000, N'K201821210')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00054', N'精液常规检查', N'人', N'次', 8.0000, N'K201821210')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00055', N'阴道分泌物检查', N'人', N'次', 5.0000, N'K201821211')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00056', N'血清结合珠蛋 白测定(HP)', N'人', N'次', 6.0000, N'K201821211')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00057', N'直接抗人球蛋白试验(Coombs)', N'人', N'次', 30.0000, N'K201821211')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00058', N'凝血常规检查(仪器法)', N'人', N'次', 80.0000, N'K201821212')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00059', N'血清总蛋白测定', N'人', N'次', 3.0000, N'K201821212')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00060', N'脑脊液总蛋白测定', N'人', N'次', 3.0000, N'K201821213')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00061', N'葡萄糖测定', N'人', N'次', 5.0000, N'K201821213')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00062', N'血脂常规检查', N'人', N'次', 30.0000, N'K201821214')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00063', N'乙肝三对检查', N'人', N'次', 30.0000, N'K201821214')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00064', N'输血前常规检查', N'人', N'次', 90.0000, N'K201821214')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00065', N'苯丙氨酸测定(PKU)', N'人', N'次', 25.0000, N'K201821215')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00066', N'液基薄层细胞制片术', N'人', N'次', 140.0000, N'K201821215')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00067', N'多媒体显微诊断（MDI）', N'人', N'次', 120.0000, N'K201821216')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00068', N'常规心电图检查', N'人', N'次', 10.0000, N'K201821216')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00069', N'基础麻醉', N'人', N'次', 30.0000, N'K201821217')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00070', N'全身麻醉', N'人', N'次', 600.0000, N'K201821233')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00071', N'单纯吸入全麻（不插管）', N'人', N'次', 50.0000, N'K201821232')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00072', N'剖腹探查术', N'人', N'次', 700.0000, N'K201821218')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00073', N'包皮环切术', N'人', N'次', 200.0000, N'K201821219')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00074', N'阴茎静脉结扎术', N'人', N'次', 900.0000, N'K201821220')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00075', N'经阴道卵巢囊肿穿刺术', N'人', N'次', 600.0000, N'K201821221')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00076', N'卵巢囊肿剔除术', N'人', N'次', 800.0000, N'K201821222')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00077', N'卵巢切除术', N'人', N'次', 700.0000, N'K201821223')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00078', N'输卵管结扎术', N'人', N'次', 300.0000, N'K201821224')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00079', N'宫颈环形电切', N'人', N'次', 500.0000, N'K201821225')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00080', N'阴道成形术', N'人', N'次', 1000.0000, N'K201821226')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00081', N'单胎顺产接生', N'人', N'次', 500.0000, N'K201821227')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00082', N'难产接生', N'人', N'次', 700.0000, N'K201821228')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00083', N'子宫颈裂伤修补术', N'人', N'次', 1000.0000, N'K201821229')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00084', N'微波治疗', N'人', N'次', 20.0000, N'K201821230')
INSERT [dbo].[HspPriceInfo] ([ProjectID], [ProjectName], [Specification], [Unit], [Price], [DepartID]) VALUES (N'Price00085', N'超声波治疗', N'人', N'次', 5.0000, N'K201821231')
/****** Object:  Table [dbo].[EmployeeInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EmployeeInfo](
	[EmployeeID] [char](10) NOT NULL,
	[EmployeeName] [varchar](30) NOT NULL,
	[GENDER] [varchar](2) NOT NULL,
	[BIRTHDAY] [date] NOT NULL,
	[IDNumber] [char](18) NOT NULL,
	[PhoneNumber] [char](11) NOT NULL,
	[Address] [varchar](50) NOT NULL,
	[EDUCATION] [varchar](10) NULL,
	[DEPARTID] [char](10) NOT NULL,
	[PostID] [char](10) NOT NULL,
	[Avatar] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821101', N'骨医生', N'男', CAST(0xBFFD0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821101', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821102', N'神医生', N'男', CAST(0x72FC0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821102', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821103', N'胸医生', N'女', CAST(0x6BFF0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821103', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821104', N'烧医生', N'男', CAST(0x85130B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821105', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821105', N'普医生', N'男', CAST(0xF2030B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821106', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821201', N'消医生', N'男', CAST(0x3BF70A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821201', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821202', N'心医生', N'女', CAST(0x76120B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821203', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821203', N'呼医生', N'女', CAST(0xBB0F0B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821204', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821204', N'血医生', N'男', CAST(0xC2EA0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821205', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'D201821205', N'内医生', N'男', CAST(0x90040B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821206', N'postm18006', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821101', N'骨护士', N'女', CAST(0xBFFD0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821101', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821102', N'神护士', N'女', CAST(0x72FC0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821102', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821103', N'胸护士', N'女', CAST(0x6BFF0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821103', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821104', N'烧护士', N'女', CAST(0x85130B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821105', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821105', N'普护士', N'女', CAST(0xF2030B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821106', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821201', N'消护士', N'女', CAST(0x3BF70A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821201', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821202', N'心护士', N'女', CAST(0x76120B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821203', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821203', N'呼护士', N'女', CAST(0xBB0F0B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821204', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821204', N'血护士', N'女', CAST(0xC2EA0A00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'硕士', N'K201821205', N'postm18007', NULL)
INSERT [dbo].[EmployeeInfo] ([EmployeeID], [EmployeeName], [GENDER], [BIRTHDAY], [IDNumber], [PhoneNumber], [Address], [EDUCATION], [DEPARTID], [PostID], [Avatar]) VALUES (N'N201821205', N'内护士', N'女', CAST(0x90040B00 AS Date), N'100201188702245248', N'17672121000', N'xx省xx市xx区xx街道xx号', N'博士', N'K201821206', N'postm18007', NULL)
/****** Object:  Table [dbo].[DoctorsAdviceInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DoctorsAdviceInfo](
	[DoctorsAdviceID] [char](10) NOT NULL,
	[EmployeeID] [char](10) NOT NULL,
	[PatientID] [char](10) NOT NULL,
	[MedicalContent] [varchar](500) NOT NULL,
	[IsExecuted] [varchar](2) NOT NULL,
	[EffectiveTime] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DoctorsAdviceID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182121', N'D201821105', N'P201821101', N'多吃药，多喝水', N'是', CAST(0x0000A8EF01815870 AS DateTime))
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182122', N'D201821102', N'P201821102', N'多锻炼，多吃药', N'是', CAST(0x0000A8EF01815870 AS DateTime))
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182123', N'D201821101', N'P201821103', N'多锻炼，多吃药', N'否', CAST(0x0000A8EF01815870 AS DateTime))
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182124', N'D201821101', N'P201821104', N'多锻炼，多吃药', N'否', CAST(0x0000A8EF01815870 AS DateTime))
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182125', N'D201821101', N'P201821105', N'多锻炼，多吃药', N'否', CAST(0x0000A8EF01815870 AS DateTime))
INSERT [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID], [EmployeeID], [PatientID], [MedicalContent], [IsExecuted], [EffectiveTime]) VALUES (N'DA20182126', N'D201821101', N'P201821106', N'多锻炼，多吃药', N'是', CAST(0x0000A8EF01815870 AS DateTime))
/****** Object:  Table [dbo].[InpatientInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[InpatientInfo](
	[HspID] [char](10) NOT NULL,
	[PatientID] [char](10) NOT NULL,
	[DepartID] [char](10) NOT NULL,
	[DoctorID] [char](10) NOT NULL,
	[NurseID] [char](10) NOT NULL,
	[BedID] [char](10) NOT NULL,
	[InHspTimes] [datetime] NOT NULL,
	[OutHspTimes] [datetime] NOT NULL,
	[AdmissionReason] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[HspID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821201', N'P201821101', N'K201821106', N'D201821102', N'N201821101', N'W201821206', CAST(0x000007C100000000 AS DateTime), CAST(0x000007D600000000 AS DateTime), N'高兴')
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821202', N'P201821102', N'K201821101', N'D201821102', N'N201821101', N'W201821105', CAST(0x000007C600000000 AS DateTime), CAST(0x000007D600000000 AS DateTime), N'非常高兴')
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821203', N'P201821103', N'K201821106', N'D201821101', N'N201821101', N'W201821101', CAST(0x000007C600000000 AS DateTime), CAST(0x000007D400000000 AS DateTime), N'骨折')
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821204', N'P201821104', N'K201821103', N'D201821101', N'N201821101', N'W201821101', CAST(0x000007C600000000 AS DateTime), CAST(0x000007D400000000 AS DateTime), N'骨折')
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821205', N'P201821105', N'K201821104', N'D201821101', N'N201821101', N'W201821101', CAST(0x000007C600000000 AS DateTime), CAST(0x000007D400000000 AS DateTime), N'骨折')
INSERT [dbo].[InpatientInfo] ([HspID], [PatientID], [DepartID], [DoctorID], [NurseID], [BedID], [InHspTimes], [OutHspTimes], [AdmissionReason]) VALUES (N'H201821206', N'P201821106', N'K201821105', N'D201821101', N'N201821101', N'W201821101', CAST(0x000007C600000000 AS DateTime), CAST(0x000007D400000000 AS DateTime), N'骨折')
/****** Object:  Table [dbo].[AppointmentCheckInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AppointmentCheckInfo](
	[CheckNum] [numeric](20, 0) NOT NULL,
	[PatientID] [char](10) NOT NULL,
	[ProjectID] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CheckNum] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[AppointmentCheckInfo] ([CheckNum], [PatientID], [ProjectID]) VALUES (CAST(1 AS Numeric(20, 0)), N'P201821101', N'Price00022')
INSERT [dbo].[AppointmentCheckInfo] ([CheckNum], [PatientID], [ProjectID]) VALUES (CAST(2 AS Numeric(20, 0)), N'P201821102', N'Price00001')
INSERT [dbo].[AppointmentCheckInfo] ([CheckNum], [PatientID], [ProjectID]) VALUES (CAST(3 AS Numeric(20, 0)), N'P201821101', N'Price00024')
/****** Object:  Table [dbo].[MedRecordInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MedRecordInfo](
	[PatientID] [char](10) NOT NULL,
	[ChiefComplaints] [nvarchar](1000) NOT NULL,
	[PresentIllness] [nvarchar](1000) NOT NULL,
	[PastHistory] [nvarchar](1000) NULL,
	[MarriageHistory] [nvarchar](1000) NULL,
	[MenstrualHistory] [nvarchar](1000) NULL,
	[FamilyHistory] [nvarchar](1000) NULL,
	[PhysicalExamination] [nvarchar](1000) NULL,
	[SpecialistInspection] [nvarchar](1000) NULL,
	[AuxiliaryInspection] [nvarchar](1000) NULL,
	[DifferentialDiagnosis] [nvarchar](1000) NULL,
	[InitialDiagnosis] [nvarchar](1000) NOT NULL,
	[AssessmentPlan] [nvarchar](1000) NOT NULL,
	[DoctorsAdviceID] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821101', N'头晕头闷伴右手抓物无力3个月加重一周。', N'患者去年12月份患脑梗塞在我院住院治疗出院后留有右手抓物不灵活症状。近一周感觉症状有所加重并出现头晕甚至不能低头洗脸在本村卫生所测血压偏高口服复方利血平片观察几天未见好转故于今日就诊于我院，患者自发病无意识丧失，无恶心呕吐及大小便失禁。  经检查已脑梗塞、高血压病收入住院，患者步入病房。', N'否认肝炎、结核病史，无外伤手术及输血史。三个月前患脑梗塞在我院治疗好转出院。患高血压病两年。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'皮肤粘膜：皮肤粘膜无黄染，纹理、弹性等均正常，无皮疹。浅表淋巴结：无肿大。头颅：头颅正常无畸形、肿物、压痛，头发疏密、色泽、分布均正常。 眼：眼结膜无充血，巩膜无黄染，角膜清晰，双瞳孔等大等圆，直径2.5mm，对光反应灵敏。耳：耳廓正常无畸形，外耳道通畅，无异常分泌物，乳突无压痛，听力正常。', N'12月份查头颅CT示：脑梗塞', N'高血压', N'1、高血压，2、脑梗塞', N'M201821101', N'DA20182121')
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821102', N'（1）首发症状出现的时间、起病缓急、症状加重或减轻的因素、治疗情况和病程的长短等。  （2）头痛：可能的原因、部位、性质、时间、规律、程度、伴发症状，头痛加剧或减轻的因素等。  （3）疼痛：部位、性质、规律、扩散，引起发作加剧的原因，对各种治疗的结果。', N'（4）麻木：性质、分布、传播、发展过程。  （5）抽搐：初发年龄、有无先兆、抽搐情况、伴发症状、发作持续时间、发作后症状、发作的规律、过去治疗情况，间歇期有无其他症状。  （6）瘫痪：起病缓急、部位、功能障碍程度、伴发症状。 （7）视力障碍：有无复视、视力减退等。', N'有无脑炎、脑膜炎、慢性支气管炎、外伤、中毒、寄生虫病、心血管病、代谢及内分泌疾病、恶性肿瘤等。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'植物神经检查：皮肤色泽、温度、营养状态、汗液分泌、皮肤划痕反应等。脑膜刺激征：颈项强直、克尼格（Kernig）征、布鲁辛斯基（Brudzinski）征。', N'深反射：左侧肱二头肌腱、肱三头肌腱、烧骨膜反射、膝腱、踝腱反射升++，右侧+++。无髌、踝阵挛。  浅反射：右侧腹壁反射消失，提睾反射消失，历反射消失；左侧均存在。肛门反射存在。  病理反射：双侧巴彬斯基征（ Babinski）恰多克征（Chaddock ），奥本汉姆征（Oppenheim），戈登征（Gordon），罗索里摩征（Rossolimo），右侧霍夫曼征（Hoffmann）。', N'脑神经错位', N'神经病', N'注意休息，服用布洛芬天天', N'DA20182122')
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821103', N'（1）首发症状出现的时间、起病缓急、症状加重或减轻的因素、治疗情况和病程的长短等。  （2）头痛：可能的原因、部位、性质、时间、规律、程度、伴发症状，头痛加剧或减轻的因素等。  （3）疼痛：部位、性质、规律、扩散，引起发作加剧的原因，对各种治疗的结果。', N'（4）麻木：性质、分布、传播、发展过程。  （5）抽搐：初发年龄、有无先兆、抽搐情况、伴发症状、发作持续时间、发作后症状、发作的规律、过去治疗情况，间歇期有无其他症状。  （6）瘫痪：起病缓急、部位、功能障碍程度、伴发症状。 （7）视力障碍：有无复视、视力减退等。', N'有无脑炎、脑膜炎、慢性支气管炎、外伤、中毒、寄生虫病、心血管病、代谢及内分泌疾病、恶性肿瘤等。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'植物神经检查：皮肤色泽、温度、营养状态、汗液分泌、皮肤划痕反应等。脑膜刺激征：颈项强直、克尼格（Kernig）征、布鲁辛斯基（Brudzinski）征。', N'深反射：左侧肱二头肌腱、肱三头肌腱、烧骨膜反射、膝腱、踝腱反射升++，右侧+++。无髌、踝阵挛。  浅反射：右侧腹壁反射消失，提睾反射消失，历反射消失；左侧均存在。肛门反射存在。  病理反射：双侧巴彬斯基征（ Babinski）恰多克征（Chaddock ），奥本汉姆征（Oppenheim），戈登征（Gordon），罗索里摩征（Rossolimo），右侧霍夫曼征（Hoffmann）。', N'脑神经错位', N'神经病', N'注意休息，服用布洛芬天天', N'DA20182123')
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821104', N'（1）首发症状出现的时间、起病缓急、症状加重或减轻的因素、治疗情况和病程的长短等。  （2）头痛：可能的原因、部位、性质、时间、规律、程度、伴发症状，头痛加剧或减轻的因素等。  （3）疼痛：部位、性质、规律、扩散，引起发作加剧的原因，对各种治疗的结果。', N'（4）麻木：性质、分布、传播、发展过程。  （5）抽搐：初发年龄、有无先兆、抽搐情况、伴发症状、发作持续时间、发作后症状、发作的规律、过去治疗情况，间歇期有无其他症状。  （6）瘫痪：起病缓急、部位、功能障碍程度、伴发症状。 （7）视力障碍：有无复视、视力减退等。', N'有无脑炎、脑膜炎、慢性支气管炎、外伤、中毒、寄生虫病、心血管病、代谢及内分泌疾病、恶性肿瘤等。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'植物神经检查：皮肤色泽、温度、营养状态、汗液分泌、皮肤划痕反应等。脑膜刺激征：颈项强直、克尼格（Kernig）征、布鲁辛斯基（Brudzinski）征。', N'深反射：左侧肱二头肌腱、肱三头肌腱、烧骨膜反射、膝腱、踝腱反射升++，右侧+++。无髌、踝阵挛。  浅反射：右侧腹壁反射消失，提睾反射消失，历反射消失；左侧均存在。肛门反射存在。  病理反射：双侧巴彬斯基征（ Babinski）恰多克征（Chaddock ），奥本汉姆征（Oppenheim），戈登征（Gordon），罗索里摩征（Rossolimo），右侧霍夫曼征（Hoffmann）。', N'脑神经错位', N'神经病', N'注意休息，服用布洛芬天天', N'DA20182124')
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821105', N'（1）首发症状出现的时间、起病缓急、症状加重或减轻的因素、治疗情况和病程的长短等。  （2）头痛：可能的原因、部位、性质、时间、规律、程度、伴发症状，头痛加剧或减轻的因素等。  （3）疼痛：部位、性质、规律、扩散，引起发作加剧的原因，对各种治疗的结果。', N'（4）麻木：性质、分布、传播、发展过程。  （5）抽搐：初发年龄、有无先兆、抽搐情况、伴发症状、发作持续时间、发作后症状、发作的规律、过去治疗情况，间歇期有无其他症状。  （6）瘫痪：起病缓急、部位、功能障碍程度、伴发症状。 （7）视力障碍：有无复视、视力减退等。', N'有无脑炎、脑膜炎、慢性支气管炎、外伤、中毒、寄生虫病、心血管病、代谢及内分泌疾病、恶性肿瘤等。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'植物神经检查：皮肤色泽、温度、营养状态、汗液分泌、皮肤划痕反应等。脑膜刺激征：颈项强直、克尼格（Kernig）征、布鲁辛斯基（Brudzinski）征。', N'深反射：左侧肱二头肌腱、肱三头肌腱、烧骨膜反射、膝腱、踝腱反射升++，右侧+++。无髌、踝阵挛。  浅反射：右侧腹壁反射消失，提睾反射消失，历反射消失；左侧均存在。肛门反射存在。  病理反射：双侧巴彬斯基征（ Babinski）恰多克征（Chaddock ），奥本汉姆征（Oppenheim），戈登征（Gordon），罗索里摩征（Rossolimo），右侧霍夫曼征（Hoffmann）。', N'脑神经错位', N'神经病', N'注意休息，服用布洛芬天天', N'DA20182125')
INSERT [dbo].[MedRecordInfo] ([PatientID], [ChiefComplaints], [PresentIllness], [PastHistory], [MarriageHistory], [MenstrualHistory], [FamilyHistory], [PhysicalExamination], [SpecialistInspection], [AuxiliaryInspection], [DifferentialDiagnosis], [InitialDiagnosis], [AssessmentPlan], [DoctorsAdviceID]) VALUES (N'P201821106', N'（1）首发症状出现的时间、起病缓急、症状加重或减轻的因素、治疗情况和病程的长短等。  （2）头痛：可能的原因、部位、性质、时间、规律、程度、伴发症状，头痛加剧或减轻的因素等。  （3）疼痛：部位、性质、规律、扩散，引起发作加剧的原因，对各种治疗的结果。', N'（4）麻木：性质、分布、传播、发展过程。  （5）抽搐：初发年龄、有无先兆、抽搐情况、伴发症状、发作持续时间、发作后症状、发作的规律、过去治疗情况，间歇期有无其他症状。  （6）瘫痪：起病缓急、部位、功能障碍程度、伴发症状。 （7）视力障碍：有无复视、视力减退等。', N'有无脑炎、脑膜炎、慢性支气管炎、外伤、中毒、寄生虫病、心血管病、代谢及内分泌疾病、恶性肿瘤等。', N'23岁结婚，生有二子，均健康', N'无', N'无', N'T 36.7℃ P 84次/分 R 20次/分 BP130/80mmHg', N'植物神经检查：皮肤色泽、温度、营养状态、汗液分泌、皮肤划痕反应等。脑膜刺激征：颈项强直、克尼格（Kernig）征、布鲁辛斯基（Brudzinski）征。', N'深反射：左侧肱二头肌腱、肱三头肌腱、烧骨膜反射、膝腱、踝腱反射升++，右侧+++。无髌、踝阵挛。  浅反射：右侧腹壁反射消失，提睾反射消失，历反射消失；左侧均存在。肛门反射存在。  病理反射：双侧巴彬斯基征（ Babinski）恰多克征（Chaddock ），奥本汉姆征（Oppenheim），戈登征（Gordon），罗索里摩征（Rossolimo），右侧霍夫曼征（Hoffmann）。', N'脑神经错位', N'神经病', N'注意休息，服用布洛芬天天', N'DA20182126')
/****** Object:  View [dbo].[InPatient]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[InPatient]
AS
select HspID, PatientName, GENDER, BIRTHDAY, IDNumber, PhoneNumber, InpatientInfo.PatientID, DepartID, DoctorID, NurseID, BedID, InHspTimes, OutHspTimes, Address, AdmissionReason
from InpatientInfo, patientInfo
where InpatientInfo.PatientID = patientInfo.PatientID
GO
/****** Object:  Table [dbo].[HspCostsInfo]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HspCostsInfo](
	[SerialNumber] [numeric](20, 0) NOT NULL,
	[PatientID] [char](10) NOT NULL,
	[HspID] [char](10) NOT NULL,
	[Time] [datetime] NOT NULL,
	[ProjectID] [char](10) NOT NULL,
	[Amount] [numeric](20, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SerialNumber] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(1 AS Numeric(20, 0)), N'P201821101', N'H201821201', CAST(0x0000A89600000000 AS DateTime), N'Price00022', CAST(5 AS Numeric(20, 0)))
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(2 AS Numeric(20, 0)), N'P201821102', N'H201821202', CAST(0x0000A89700000000 AS DateTime), N'Price00001', CAST(1 AS Numeric(20, 0)))
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(3 AS Numeric(20, 0)), N'P201821103', N'H201821203', CAST(0x0000A8D400000000 AS DateTime), N'Price00004', CAST(9 AS Numeric(20, 0)))
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(4 AS Numeric(20, 0)), N'P201821104', N'H201821204', CAST(0x0000A8D600000000 AS DateTime), N'Price00005', CAST(3 AS Numeric(20, 0)))
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(5 AS Numeric(20, 0)), N'P201821105', N'H201821205', CAST(0x0000A8D700000000 AS DateTime), N'Price00003', CAST(6 AS Numeric(20, 0)))
INSERT [dbo].[HspCostsInfo] ([SerialNumber], [PatientID], [HspID], [Time], [ProjectID], [Amount]) VALUES (CAST(6 AS Numeric(20, 0)), N'P201821106', N'H201821206', CAST(0x0000A8D800000000 AS DateTime), N'Price00006', CAST(2 AS Numeric(20, 0)))
/****** Object:  View [dbo].[CostSchedule]    Script Date: 05/29/2018 11:19:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[CostSchedule]
AS
SELECT patientInfo.PatientID, PatientName, HspPriceInfo.ProjectName, HspCostsInfo.Time, Specification, Unit, Price, HspPriceInfo.Price*HspCostsInfo.Amount CostSchedule
FROM HspPriceInfo, HspCostsInfo, patientInfo
where HspCostsInfo.PatientID = patientInfo.PatientID
	and HspPriceInfo.ProjectID = HspCostsInfo.ProjectID
GO
/****** Object:  ForeignKey [Diseases_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[DepartInfo]  WITH CHECK ADD  CONSTRAINT [Diseases_fk] FOREIGN KEY([DiseasesID])
REFERENCES [dbo].[PushInfo] ([DiseasesID])
GO
ALTER TABLE [dbo].[DepartInfo] CHECK CONSTRAINT [Diseases_fk]
GO
/****** Object:  ForeignKey [FK__DepartInf__PostI__09DE7BCC]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[DepartInfo]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[PostInfo] ([PostID])
GO
/****** Object:  ForeignKey [DEPARTID1_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[BedInfo]  WITH CHECK ADD  CONSTRAINT [DEPARTID1_fk] FOREIGN KEY([DEPARTID])
REFERENCES [dbo].[DepartInfo] ([DEPARTID])
GO
ALTER TABLE [dbo].[BedInfo] CHECK CONSTRAINT [DEPARTID1_fk]
GO
/****** Object:  ForeignKey [DepartID3_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[HspPriceInfo]  WITH CHECK ADD  CONSTRAINT [DepartID3_fk] FOREIGN KEY([DepartID])
REFERENCES [dbo].[DepartInfo] ([DEPARTID])
GO
ALTER TABLE [dbo].[HspPriceInfo] CHECK CONSTRAINT [DepartID3_fk]
GO
/****** Object:  ForeignKey [DEPARTID22_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[EmployeeInfo]  WITH CHECK ADD  CONSTRAINT [DEPARTID22_fk] FOREIGN KEY([DEPARTID])
REFERENCES [dbo].[DepartInfo] ([DEPARTID])
GO
ALTER TABLE [dbo].[EmployeeInfo] CHECK CONSTRAINT [DEPARTID22_fk]
GO
/****** Object:  ForeignKey [PostID22_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[EmployeeInfo]  WITH CHECK ADD  CONSTRAINT [PostID22_fk] FOREIGN KEY([PostID])
REFERENCES [dbo].[PostInfo] ([PostID])
GO
ALTER TABLE [dbo].[EmployeeInfo] CHECK CONSTRAINT [PostID22_fk]
GO
/****** Object:  ForeignKey [EmployeeID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[DoctorsAdviceInfo]  WITH CHECK ADD  CONSTRAINT [EmployeeID_fk] FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[EmployeeInfo] ([EmployeeID])
GO
ALTER TABLE [dbo].[DoctorsAdviceInfo] CHECK CONSTRAINT [EmployeeID_fk]
GO
/****** Object:  ForeignKey [PatientID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[DoctorsAdviceInfo]  WITH CHECK ADD  CONSTRAINT [PatientID_fk] FOREIGN KEY([PatientID])
REFERENCES [dbo].[PatientInfo] ([PatientID])
GO
ALTER TABLE [dbo].[DoctorsAdviceInfo] CHECK CONSTRAINT [PatientID_fk]
GO
/****** Object:  ForeignKey [BedID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[InpatientInfo]  WITH CHECK ADD  CONSTRAINT [BedID_fk] FOREIGN KEY([BedID])
REFERENCES [dbo].[BedInfo] ([BedID])
GO
ALTER TABLE [dbo].[InpatientInfo] CHECK CONSTRAINT [BedID_fk]
GO
/****** Object:  ForeignKey [DepartID2_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[InpatientInfo]  WITH CHECK ADD  CONSTRAINT [DepartID2_fk] FOREIGN KEY([DepartID])
REFERENCES [dbo].[DepartInfo] ([DEPARTID])
GO
ALTER TABLE [dbo].[InpatientInfo] CHECK CONSTRAINT [DepartID2_fk]
GO
/****** Object:  ForeignKey [DoctorID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[InpatientInfo]  WITH CHECK ADD  CONSTRAINT [DoctorID_fk] FOREIGN KEY([DoctorID])
REFERENCES [dbo].[EmployeeInfo] ([EmployeeID])
GO
ALTER TABLE [dbo].[InpatientInfo] CHECK CONSTRAINT [DoctorID_fk]
GO
/****** Object:  ForeignKey [NurseIDfk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[InpatientInfo]  WITH CHECK ADD  CONSTRAINT [NurseIDfk] FOREIGN KEY([NurseID])
REFERENCES [dbo].[EmployeeInfo] ([EmployeeID])
GO
ALTER TABLE [dbo].[InpatientInfo] CHECK CONSTRAINT [NurseIDfk]
GO
/****** Object:  ForeignKey [PatientID3_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[InpatientInfo]  WITH CHECK ADD  CONSTRAINT [PatientID3_fk] FOREIGN KEY([PatientID])
REFERENCES [dbo].[PatientInfo] ([PatientID])
GO
ALTER TABLE [dbo].[InpatientInfo] CHECK CONSTRAINT [PatientID3_fk]
GO
/****** Object:  ForeignKey [PatientID5_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[AppointmentCheckInfo]  WITH CHECK ADD  CONSTRAINT [PatientID5_fk] FOREIGN KEY([PatientID])
REFERENCES [dbo].[PatientInfo] ([PatientID])
GO
ALTER TABLE [dbo].[AppointmentCheckInfo] CHECK CONSTRAINT [PatientID5_fk]
GO
/****** Object:  ForeignKey [ProjectID2_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[AppointmentCheckInfo]  WITH CHECK ADD  CONSTRAINT [ProjectID2_fk] FOREIGN KEY([ProjectID])
REFERENCES [dbo].[HspPriceInfo] ([ProjectID])
GO
ALTER TABLE [dbo].[AppointmentCheckInfo] CHECK CONSTRAINT [ProjectID2_fk]
GO
/****** Object:  ForeignKey [DoctorsAdviceID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[MedRecordInfo]  WITH CHECK ADD  CONSTRAINT [DoctorsAdviceID_fk] FOREIGN KEY([DoctorsAdviceID])
REFERENCES [dbo].[DoctorsAdviceInfo] ([DoctorsAdviceID])
GO
ALTER TABLE [dbo].[MedRecordInfo] CHECK CONSTRAINT [DoctorsAdviceID_fk]
GO
/****** Object:  ForeignKey [PatientID2_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[MedRecordInfo]  WITH CHECK ADD  CONSTRAINT [PatientID2_fk] FOREIGN KEY([PatientID])
REFERENCES [dbo].[PatientInfo] ([PatientID])
GO
ALTER TABLE [dbo].[MedRecordInfo] CHECK CONSTRAINT [PatientID2_fk]
GO
/****** Object:  ForeignKey [HspID4_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[HspCostsInfo]  WITH CHECK ADD  CONSTRAINT [HspID4_fk] FOREIGN KEY([HspID])
REFERENCES [dbo].[InpatientInfo] ([HspID])
GO
ALTER TABLE [dbo].[HspCostsInfo] CHECK CONSTRAINT [HspID4_fk]
GO
/****** Object:  ForeignKey [PatientID4_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[HspCostsInfo]  WITH CHECK ADD  CONSTRAINT [PatientID4_fk] FOREIGN KEY([PatientID])
REFERENCES [dbo].[PatientInfo] ([PatientID])
GO
ALTER TABLE [dbo].[HspCostsInfo] CHECK CONSTRAINT [PatientID4_fk]
GO
/****** Object:  ForeignKey [ProjectID_fk]    Script Date: 05/29/2018 11:19:29 ******/
ALTER TABLE [dbo].[HspCostsInfo]  WITH CHECK ADD  CONSTRAINT [ProjectID_fk] FOREIGN KEY([ProjectID])
REFERENCES [dbo].[HspPriceInfo] ([ProjectID])
GO
ALTER TABLE [dbo].[HspCostsInfo] CHECK CONSTRAINT [ProjectID_fk]
GO
